package com.example.lenovo.callcentre;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;



import org.w3c.dom.Text;

public class News_Activity extends AppCompatActivity {
Bitmap bitmap; //to extract color swatch
    Palette palette;
boolean fav=false;

    CollapsingToolbarLayout collapsingToolbarLayout;
    NestedScrollView nestedScrollView;
    TextView contents_text;
    AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent in=getIntent();
        Bundle r=in.getExtras();
        String s=r.getString("title");
        int i=r.getInt("cover");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        nestedScrollView=(NestedScrollView)findViewById(R.id.textBackground);
        appBarLayout=(AppBarLayout)findViewById(R.id.app_bar);
        contents_text=(TextView)findViewById(R.id.content_text);
        collapsingToolbarLayout.setTitle(s);
        setSupportActionBar(toolbar);
       bitmap=null;
       bitmap=BitmapFactory.decodeResource(getApplicationContext().getResources(),i);
        appBarLayout.setBackgroundResource(i);
        //Drawable myDrawable = getResources().getDrawable(R.drawable.images);
      //bitmap= ((BitmapDrawable) myDrawable).getBitmap();
       palette= Palette.from(bitmap).generate();
      Palette.Swatch psVibrant = palette.getVibrantSwatch();
       Palette.Swatch psVibrantDark = palette.getDarkVibrantSwatch();
      int color=psVibrant.getRgb();
      int text_color=palette.getLightVibrantColor(0);
       collapsingToolbarLayout.setContentScrimColor(color);
       collapsingToolbarLayout.setExpandedTitleColor(text_color);
       int color_g1=palette.getDarkVibrantColor(0)+10;
        int color_g2=palette.getVibrantColor(0)+100;
        //set text color for ^^^
      //  contents_text.setTextColor(palette.getLightVibrantColor(0));
        contents_text.setTextColor(Color.WHITE);
        //contents_text.setShadowLayer(10,2,5,Color.WHITE);
        setGradientColor(color_g1,Color.BLACK);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       fab.setBackgroundTintList(ColorStateList.valueOf(palette.getLightVibrantColor(0)));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!fav) {
                    Snackbar.make(view, "Article is added to favourite list!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    fab.setImageResource(R.drawable.ic_favorite);
                    fav=true;
                }
                else{fab.setImageResource(R.drawable.ic_favourite_off);
                fav=false;
                    Snackbar.make(view, "Article is removed from favourite list!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

    }
    public void setGradientColor(int endColor, int startColor) {
            GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]  {endColor, startColor});
            gradient.setShape(GradientDrawable.RECTANGLE);
           nestedScrollView.setBackground(gradient);
        }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();

    }
}
