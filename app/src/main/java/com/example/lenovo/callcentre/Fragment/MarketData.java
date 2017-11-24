package com.example.lenovo.callcentre.Fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.callcentre.Adapter.TabPagerAdapter;
import com.example.lenovo.callcentre.Fragment.BasicFood_Fragment;
import com.example.lenovo.callcentre.Fragment.CurrencyExchange_Fragment;
import com.example.lenovo.callcentre.Fragment.Fuel_Fragment;
import com.example.lenovo.callcentre.R;

import java.util.ArrayList;

public class MarketData extends Fragment {
    //region[variable]
    private ViewPager viewPager;
    TabLayout tabLayout;
    int icon[]={R.drawable.ic_money,R.drawable.ic_petrol,R.drawable.ic_rice};
//endregion

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.activity_market_data,container,false);
        viewPager=(ViewPager)view.findViewById(R.id.viewPagerID);
        setupViewPager(viewPager);
        tabLayout=(TabLayout)view.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(icon[0]);
        tabLayout.getTabAt(1).setIcon(icon[1]);
        tabLayout.getTabAt(2).setIcon(icon[2]);
        tabLayout.setTabTextColors(Color.BLACK,Color.BLUE);
        setRetainInstance(true);

        return view;
    }

    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void setupViewPager(ViewPager viewPager) {
        TabPagerAdapter adapter=new TabPagerAdapter(getFragmentManager());

        viewPager.setAdapter(adapter);
    }
}
