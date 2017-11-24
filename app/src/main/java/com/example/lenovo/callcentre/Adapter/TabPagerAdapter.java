package com.example.lenovo.callcentre.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.lenovo.callcentre.Fragment.BasicFood_Fragment;
import com.example.lenovo.callcentre.Fragment.CurrencyExchange_Fragment;
import com.example.lenovo.callcentre.Fragment.Fuel_Fragment;

import java.util.ArrayList;

/**
 * Created by Lenovo on 9/12/2017.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    int TAB_NO=3;
ArrayList<String> tabName;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        tabName=new ArrayList<>();
        setTabName();
    }

    private void setTabName(){
        tabName.add("Currency Exchange Rate");
        tabName.add("Fuel Price");
        tabName.add("Basic Food Price");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabName.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CurrencyExchange_Fragment();
            case 1:
                return new Fuel_Fragment();
            case 2:
                return new BasicFood_Fragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return TAB_NO;
    }
}
