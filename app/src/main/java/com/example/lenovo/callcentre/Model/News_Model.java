package com.example.lenovo.callcentre.Model;

import android.widget.ImageView;

/**
 * Created by Lenovo on 9/7/2017.
 */

public class News_Model  {
    private String Title;
    private String Body;
    private int  Image;

    public News_Model(String title, String body,int image) {
        Title = title;
        Body = body;
        Image=image;
    }

    public String getTitle() {
        return Title;
    }

    public String getBody() {
        return Body;
    }

    public int getImage() {
        return Image;
    }
}
