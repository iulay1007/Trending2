package com.example.trendingtwo.View;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendingtwo.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class RecyclerviewAdaper  extends RecyclerView.Adapter<RecyclerviewAdaper.VH>{
    public Context context;
    private ItemClickListener mItemClickListener ;
    public interface ItemClickListener{
        public void onItemClick(int position,RecyclerviewAdaper.VH holder) ;
    }
    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener ;

    }


    public RecyclerviewAdaper(Context context){
        this.context = context;


    }

    @NonNull
    @Override
    public RecyclerviewAdaper.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_layout,null);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerviewAdaper.VH holder, final int position) {


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

        }
    }

}

