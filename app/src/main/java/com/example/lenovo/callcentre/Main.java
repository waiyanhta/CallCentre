package com.example.lenovo.callcentre;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.lenovo.callcentre.Fragment.CallCentreList;

public class Main extends AppCompatActivity implements View.OnClickListener {
    VideoView videoView;
    Handler animationHandler;
    ImageView logo_image;
    TextView about_textview;
    Button button;
    Animation animation,fadein_animation, zoom_animation;

    Interpolator interpolator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=(VideoView)findViewById(R.id.videoView) ;
        logo_image=(ImageView)findViewById(R.id.logo_imageview) ;
        about_textview=(TextView)findViewById(R.id.about_textview_ui);
        button=(Button)findViewById(R.id.button);
        setVideoView();
      //  getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button.setOnClickListener(this);


    }

/***set video view method***/
    private void setVideoView(){
        String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);

        setAnimation();
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

    }
    /****Animation Sect*****/
    private void setAnimation(){

        animationHandler=new Handler();
        interpolator=new AccelerateDecelerateInterpolator();
        fadein_animation=AnimationUtils.loadAnimation(this,R.anim.fadein);
        animation=AnimationUtils.loadAnimation(this,R.anim.slide_up);
        zoom_animation=AnimationUtils.loadAnimation(this,R.anim.zoom_out);
        fadein_animation.setDuration(1000);
        animation.setDuration(2000);
        animation.setInterpolator(interpolator);
        about_textview.setVisibility(View.GONE);
        zoom_animation.setDuration(10000);
        videoView.startAnimation(zoom_animation);


        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                about_textview.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                about_textview.startAnimation(fadein_animation);
                button.startAnimation(fadein_animation);

                animationHandler.postDelayed(scroll,3000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        logo_image.startAnimation(animation);


    }

    private Runnable scroll=new Runnable() {
        @Override
        public void run() {
            about_textview.scrollBy(0,1);
            animationHandler.postDelayed(this,50);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animationHandler.removeCallbacks(scroll);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:{
                Intent newintent=new Intent(this,CallCentre.class);
                startActivity(newintent);
            }
        }
    }
}
