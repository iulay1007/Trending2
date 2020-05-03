package com.example.trendingtwo.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.trendingtwo.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private RecyclerviewAdaper mAdaper;
    private RecyclerView recyclerView;
    private boolean itemclick=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_title);
        recyclerView =(RecyclerView)findViewById(R.id.recyclerview);
        /////
        recyclerView.setAdapter(mAdaper=new RecyclerviewAdaper(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        mAdaper.setOnItemClickListener(new RecyclerviewAdaper.ItemClickListener() {
            @Override

            public void onItemClick(int position,RecyclerviewAdaper.VH holder) {

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


                ;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
