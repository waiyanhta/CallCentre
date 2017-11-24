package com.example.lenovo.callcentre.Adapter;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.callcentre.Model.News_Model;
import com.example.lenovo.callcentre.News_Activity;
import com.example.lenovo.callcentre.R;

import java.util.ArrayList;

/**
 * Created by Lenovo on 9/7/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    Palette palette;
    private Context mContext;
    private ArrayList<News_Model> newsList;
    private int lastPosition = -1;

    int x,y;
    //declare interface
    private OnItemClicked onClick;
    //make interface like this
    public interface OnItemClicked {
        void onItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        LinearLayout container;
        public MyViewHolder(View view) {
            super(view);
            container=(LinearLayout)view.findViewById(R.id.card_newsitem_id);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);

        }
    }
    public NewsAdapter(Context mContext, ArrayList<News_Model> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
        this.newsList = newsList;
    }
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_news,parent,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final NewsAdapter.MyViewHolder holder, int position) {
        final News_Model news_model=newsList.get(position);
        holder.title.setText(news_model.getTitle());
        holder.count.setText(news_model.getBody());
        holder.count.setBackgroundColor(RelevantColor(news_model.getImage()));
        holder.thumbnail.setImageResource(news_model.getImage());
        holder.thumbnail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x=(int)event.getX();
                y=(int)event.getY();

                return false;
            }
        });

        ////
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String transitionName = "hello";
                View viewStart=holder.thumbnail;
                Toast.makeText(mContext, news_model.getTitle(), Toast.LENGTH_SHORT).show();
                Intent a =new Intent(mContext, News_Activity.class);
                Bundle b=new Bundle();
              ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeScaleUpAnimation(viewStart,x,y,0,0);

             //   ActivityOptionsCompat acompat=ActivityOptionsCompat.makeThumbnailScaleUpAnimation(viewStart,BitmapFactory.decodeResource(mContext.getResources(),news_model.getImage()),x,y);

                Toast.makeText(mContext, String.valueOf(holder.thumbnail.getX()), Toast.LENGTH_SHORT).show();
                b.putString("title",news_model.getTitle());
                b.putInt("cover",news_model.getImage());
                a.putExtras(b);
                ActivityCompat.startActivity(mContext,a,optionsCompat.toBundle());

            }
        });
        setAnimation(holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    private int RelevantColor(int image)
    {   palette= Palette.from(BitmapFactory.decodeResource(mContext.getResources(),image)).generate();
        return getTransparentColor(palette.getMutedColor(0));
    }
    private int getTransparentColor(int color){
        int alpha = Color.alpha(color);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        // Set alpha based on your logic, here I'm making it 25% of it's initial value.
        alpha *= 0.8;
        return Color.argb(alpha, red, green, blue);
    }
    /**
     * Here is the key method to apply the animation
     */

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }




}
