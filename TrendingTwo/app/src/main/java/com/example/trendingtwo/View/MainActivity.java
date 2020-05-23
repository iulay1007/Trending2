package com.example.trendingtwo.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonAdapter;
import com.example.trendingtwo.Model.JsonBean;
import com.example.trendingtwo.Model.NetworkManager;
import com.example.trendingtwo.Model.RetrofitService;
import com.example.trendingtwo.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private  String TAG ="MainActivity";
    private RecyclerviewAdapter mAdaper;
    private RecyclerView recyclerView;
//private RecyclerViewSkeletonScreen.Builder mSkeleton;
//private final SkeletonAdapter mSkeletonAdapter;
    private boolean itemclick=false;
    private Button mButton;


    public static List<JsonBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_title);

        recyclerView = findViewById(R.id.recyclerview);
        mButton=(Button)findViewById(R.id.retry);

        mSwipeRefreshLayout=  findViewById(R.id.refreshlayout);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.refresh1);

      //  mSkeleton=Skeleton.bind(recyclerView).adapter(mAdaper).load(R.layout.layout_default_item_skeleton);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefreshData();
                mSwipeRefreshLayout.setRefreshing(false);


            }
        });

       RefreshData();


        /////
        recyclerView.setAdapter(mAdaper=new RecyclerviewAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));





        mAdaper.setOnItemClickListener(new RecyclerviewAdapter.ItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override

            public void onItemClick(int position,RecyclerviewAdapter.VH holder) {



                if(itemclick==false){
                    holder.description.setVisibility(TextView.VISIBLE);
                    holder.language.setVisibility(TextView.VISIBLE);
                    holder.num_one.setVisibility(TextView.VISIBLE);
                    holder.num_two.setVisibility(TextView.VISIBLE);

                    holder.cir.setVisibility(ImageView.VISIBLE);
                    holder.star.setVisibility(ImageView.VISIBLE);
                    holder.fork.setVisibility(ImageView.VISIBLE);


                 itemclick=true;
                }
                else
                {
                    holder.description.setVisibility(TextView.GONE);
                    holder.language.setVisibility(TextView.GONE);
                    holder.num_one.setVisibility(TextView.GONE);
                    holder.num_two.setVisibility(TextView.GONE);
                    holder.cir.setVisibility(ImageView.GONE);
                    holder.star.setVisibility(ImageView.GONE);
                    holder.fork.setVisibility(ImageView.GONE);
                    itemclick=false;

                }


            }
        });
    }
    public void onClickButton(View view){

        initSwipeLayout();
        setContentView(R.layout.activity_main);
        recyclerView.setAdapter(mAdaper=new RecyclerviewAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));


        RefreshData();


    }
    public void initSwipeLayout(){
        mSwipeRefreshLayout.setColorSchemeResources(R.color.refresh1);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefreshData();
                mSwipeRefreshLayout.setRefreshing(false);


            }
        });


    }
    public void RefreshData(){
        list.clear();


        NetworkManager.getInstance(mAdaper).getRetrofitService().getBean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<JsonBean>>() {
                    Disposable d;
                    @Override
                    public void onSubscribe(Disposable d) {

                        this.d=d;
                    }

                    @Override
                    public void onNext(List<JsonBean> jsonResults) {
                        Log.d(TAG,"mydata --->"+jsonResults.get(0).getAuthor());

                        mAdaper.setData(jsonResults);

                    }

                    @Override
                    public void onError(Throwable e) {






                        setContentView(R.layout.error_layout);
                        Log.d(TAG,"error --->"+e.toString());
                    }

                    @Override
                    public void onComplete() {

                        d.dispose();
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
