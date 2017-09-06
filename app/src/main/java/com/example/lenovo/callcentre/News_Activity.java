package com.example.lenovo.callcentre;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class News_Activity extends AppCompatActivity {
Bitmap bitmap; //to extract color swatch
    Palette palette;
CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.news);
        palette= Palette.from(bitmap).generate();
        Palette.Swatch psVibrant = palette.getVibrantSwatch();
        Palette.Swatch psVibrantDark = palette.getDarkVibrantSwatch();
        int color=psVibrant.getRgb();
        int text_color=psVibrantDark.getRgb();
        collapsingToolbarLayout.setContentScrimColor(color);
        collapsingToolbarLayout.setExpandedTitleColor(text_color);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
