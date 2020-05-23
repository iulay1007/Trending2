package com.example.trendingtwo.View;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendingtwo.Model.JsonBean;
import com.example.trendingtwo.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter  extends RecyclerView.Adapter<RecyclerviewAdapter.VH>{
    public Context context;
    private ItemClickListener mItemClickListener ;
    private List<JsonBean> mJsonBeanList=new ArrayList<>();


   public void setData(List<JsonBean> list) {
   mJsonBeanList.clear();
   mJsonBeanList=list;

      notifyDataSetChanged();

  }

    public interface ItemClickListener{
        public void onItemClick(int position,RecyclerviewAdapter.VH holder) ;
    }
    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener ;

    }


    public RecyclerviewAdapter(Context context){
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerviewAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_layout,null);

        return new VH(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull final RecyclerviewAdapter.VH holder, final int position) {




       holder.author.setText(mJsonBeanList.get(position).getAuthor());
       holder.name.setText(mJsonBeanList.get(position).getName());
       holder.description.setText(mJsonBeanList.get(position).getDescription());
       holder.language.setText(mJsonBeanList.get(position).getLanguage());
      holder.image.setImageURI(mJsonBeanList.get(position).getAvatar());
      holder.num_one.setText(String.valueOf(mJsonBeanList.get(position).getStars()));
      holder.num_two.setText(String.valueOf(mJsonBeanList.get(position).getForks()));
        try {
            if(mJsonBeanList.get(position).getLanguage()==null==false){




                holder.cir.setBackground(holder.drawable);
                holder.cir.setVisibility(ImageView.VISIBLE);
                holder.drawable.setColor(Color.parseColor(mJsonBeanList.get(position).getLanguageColor()));


            }
            else  {

                holder.cir.setVisibility(ImageView.GONE);

            }

        }catch (Exception e){}

        holder.description.setVisibility(TextView.GONE);
        holder.language.setVisibility(TextView.GONE);
        holder.num_one.setVisibility(TextView.GONE);
        holder.num_two.setVisibility(TextView.GONE);
        holder.cir.setVisibility(ImageView.GONE);
        holder.star.setVisibility(ImageView.GONE);
        holder.fork.setVisibility(ImageView.GONE);



        if (mItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 这里利用回调来给RecyclerView设置点击事件
                    mItemClickListener.onItemClick(position,holder);


                }
            });
        }

    }

    @Override
    public int getItemCount() {
        //!!!!!!!!!!!!!
     if(mJsonBeanList==null==false)
       return mJsonBeanList.size();
     else
        return 15;
    }




    public static class VH extends RecyclerView.ViewHolder{


        //  SimpleDraweeView avatur;
        TextView author;
        TextView name;
        TextView description;
        TextView language;
        TextView num_one;
        TextView num_two;
        ImageView cir;
        ImageView star;
        ImageView fork;
        GradientDrawable drawable;

        SimpleDraweeView image;
        public VH(@NonNull View itemView) {
            super(itemView);
//gravity解决
            itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT));

            //   avatur=(SimpleDraweeView)itemView.findViewById(R.id.avatur);
            author=(TextView)itemView.findViewById(R.id.author);
            name = (TextView) itemView.findViewById(R.id.name);
            description=(TextView)itemView.findViewById(R.id.description);
            language = (TextView) itemView.findViewById(R.id.language);
            num_one=(TextView)itemView.findViewById(R.id.num_one);
            num_two=(TextView)itemView.findViewById(R.id.num_two);
            cir=(ImageView)itemView.findViewById(R.id.cir);
            star=(ImageView)itemView.findViewById(R.id.star);
            fork=(ImageView)itemView.findViewById(R.id.fork);
            image=(SimpleDraweeView)itemView.findViewById(R.id.avatur);
            drawable=(GradientDrawable) itemView.getResources().getDrawable(R.drawable.circle_three);

        }
    }

}

