package com.example.lenovo.callcentre.Fragment;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.example.lenovo.callcentre.Adapter.NewsAdapter;
import com.example.lenovo.callcentre.Model.News_Model;
import com.example.lenovo.callcentre.R;

import java.util.ArrayList;

public class NewsList extends Fragment {

RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private ArrayList<News_Model> news_list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     final View view=inflater.inflate(R.layout.activity_news_list,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        news_list=new ArrayList<>();
        newsAdapter=new NewsAdapter(getContext(),news_list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newsAdapter);
        prepareNews();
        setRetainInstance(true);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void prepareNews(){
        int [] covers=new int[]{R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
     };

    News_Model news_model=new News_Model("Discovery","We have gone so far from the surface of the ocean. Under the ocean, there're so many underwater species !",covers[0]);
     news_list.add(news_model);

        news_model=new News_Model("The Car","We have gone so far in automobile industry. Here Ford Motor produce new Off-Road SUV. Very smooth supension and 4X4 Power Train can bring new experience!",covers[1]);
        news_list.add(news_model);

        news_model=new News_Model("Escape","We have gone so far in dailylife. Sometime our life so boring. Escape from the stressful environment by going trip!",covers[2]);
        news_list.add(news_model);

        news_model=new News_Model("Under the Ocean","No Tiger is there! :D",covers[3]);
        news_list.add(news_model);

        newsAdapter.notifyDataSetChanged();
    }

    private void showProgress(){
        ProgressDialog progress = new ProgressDialog(getContext());
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
// To dismiss the dialog
        progress.dismiss();
    }
}
