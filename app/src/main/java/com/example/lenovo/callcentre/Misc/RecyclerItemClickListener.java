package com.example.lenovo.callcentre.Misc;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Lenovo on 9/8/2017.
 */

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
   private AdapterView.OnItemClickListener mListener;

   public  interface OnItemClickListener{
       public void onItemClick (View view, int position);
   }

   GestureDetector mGestureDetector;

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
