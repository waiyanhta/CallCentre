package com.example.lenovo.callcentre;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lenovo.callcentre.Fragment.CallCentreList;
import com.example.lenovo.callcentre.Fragment.MarketData;
import com.example.lenovo.callcentre.Fragment.NewsList;

public class Menu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
//region Class Variable
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_bar);
        frameLayout=(FrameLayout)findViewById(R.id.frm_layout);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.callcentre:  FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frm_layout,new CallCentreList());
                ft.commit();
                break;
            case R.id.news: FragmentTransaction fn=getSupportFragmentManager().beginTransaction();
                fn.replace(R.id.frm_layout, new NewsList());
                fn.commit();
                break;
            case R.id.marketdata: FragmentTransaction fmarket=getSupportFragmentManager().beginTransaction();
                fmarket.replace(R.id.frm_layout, new MarketData());
                fmarket.commit();
                break;
        }
        return true;
    }
}
