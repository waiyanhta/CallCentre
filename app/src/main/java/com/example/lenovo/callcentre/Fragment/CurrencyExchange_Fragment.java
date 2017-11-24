package com.example.lenovo.callcentre.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.callcentre.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
public class CurrencyExchange_Fragment extends Fragment{

    //region control
    private static int ANIMATION_XDURATION=500;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private static int ANIMATION_YDURATION=0;
    RadioGroup radioGroup;
    LineChart lineChart;
    //endregion

    public CurrencyExchange_Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_currency_exchange_, container, false);
        radioGroup=(RadioGroup)view.findViewById(R.id.radiogroup_id);

        BarChart barChart=(BarChart)view.findViewById(R.id.currency_chart);
        barChart.setDescription("");
        barChart.getLegend().setEnabled(false);
        //region[barchar}
        BarData barData=new BarData(getXAxisValues(),getDataSet());
        barChart.setData(barData);
        barChart.animateXY(ANIMATION_XDURATION, ANIMATION_YDURATION);
        barChart.getBarData().setValueTextSize(15.0f);
        barChart.setDrawGridBackground(false);
        barChart.setBackgroundColor(Color.TRANSPARENT);
        barChart.getBarData().setValueTextColor(Color.GREEN);
        barChart.invalidate();
        //endregion

        //region[Line Chart]
        lineChart=(LineChart)view.findViewById(R.id.lineChart);
        lineChart.setDescription("");
       // SetChartData(990f,1000f,950f,920f,1000f,980f,1050f,"SGD");
        SetChartData(1000f,1100f,1150f,1200f,1140f,1110f,1050f,"US");
        //endregion



        // Inflate the layout for this fragment

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.us:
                        SetChartData(1000f,1100f,1150f,1200f,1140f,1110f,1050f,"US");
                        break;
                    case R.id.sgd:
                        SetChartData(990f,1000f,950f,920f,1000f,980f,1050f,"SGD");
                        break;
                    case R.id.eur:
                        SetChartData(990f,1000f,950f,920f,1000f,980f,1050f,"EUR");
                        break;
                    case R.id.my:
                        SetChartData(390f,380f,350f,320f,380f,340f,370f,"MY");
                        break;
                    default:
                }
            }
        });
        return view;
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(1200.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(1000.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(350.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(1700.000f, 3); // Apr
        valueSet1.add(v1e4);


        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "USD");
        barDataSet1.setColors(ColorTemplate.VORDIPLOM_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);

        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("US");
        xAxis.add("SGD");
        xAxis.add("MY");
        xAxis.add("EUR");
        return xAxis;
    }

    private ArrayList<String>getXAxisLineChartValue(){
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("MON");
        xAxis.add("TUE");
        xAxis.add("WED");
        xAxis.add("THU");
        xAxis.add("FRI");
        xAxis.add("SAT");
        xAxis.add("SUN");
        return xAxis;
    }

    private ArrayList<LineDataSet> getDataSetLineChart(float f1,float f2, float f3,float f4,float f5,float f6,float f7,String title) {
        ArrayList<LineDataSet> dataSets = null;
        LineDataSet SGD=new LineDataSet(setWeekData(f1,f2,f3,f4,f5,f6,f7),title);
       // SGD.setColor(Color.RED);
        SGD.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSets = new ArrayList<>();
        dataSets.add(SGD);
        return dataSets;
    }

    private ArrayList<Entry> setWeekData(float f1, float f2, float f3, float f4, float f5, float f6, float f7)
    {
        ArrayList<Entry> valueSet1 = new ArrayList<>();
        Entry v1e1 = new Entry(f1, 0); // Mon
        valueSet1.add(v1e1);
        Entry v1e2 = new Entry(f2, 1); // Tue
        valueSet1.add(v1e2);
        Entry v1e3 = new BarEntry(f3, 2); // Wed
        valueSet1.add(v1e3);
        Entry v1e4 = new Entry(f4, 3); // Thur
        valueSet1.add(v1e4);
        Entry v1e5=new Entry(f5,4);//Fri
        valueSet1.add(v1e5);
        Entry v1e6=new Entry(f6,5);//Sat
        valueSet1.add(v1e6);
        Entry v1e7=new Entry(f7,6);//Sun
        valueSet1.add(v1e7);
        return  valueSet1;
    }

    private void SetChartData(float a,float b,float c, float d, float e,float f,float g,String title){
        LineData lineData=new LineData(getXAxisLineChartValue(),getDataSetLineChart(a,b,c,d,e,f,g,title));
        lineChart.setData(lineData);
        lineChart.setBackgroundColor(Color.TRANSPARENT);
        lineChart.animateXY(ANIMATION_XDURATION,ANIMATION_YDURATION);
        lineChart.getLineData().setValueTextSize(10f);
        lineChart.getLineData().setValueTextColor(Color.GREEN);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisLeft().setStartAtZero(false);
        lineChart.getAxisRight().setStartAtZero(false);
        lineChart.getAxisRight().setShowOnlyMinMax(true);
        lineChart.getAxisLeft().setShowOnlyMinMax(true);
        lineChart.setDrawGridBackground(false);
        XAxis xAxis=lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.fitScreen();
        lineChart.invalidate();
    }

}
