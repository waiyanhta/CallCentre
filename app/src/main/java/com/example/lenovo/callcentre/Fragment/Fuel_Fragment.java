package com.example.lenovo.callcentre.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.lenovo.callcentre.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class Fuel_Fragment extends Fragment implements RadioButton.OnClickListener{

//region class variable
    RadioButton rb_diesel,rb_pdiesel,rb_90,rb_92,rb_95;
   RadioButton[] rbarray;
    int [] radiobutton_id={R.id.diesel,R.id.pdiesel,R.id.ron90,R.id.ron92,R.id.ron95};
    BarChart barChart;
    LineChart lineChart;
    private static int ANIMATION_XDURATION=300;
    private static int ANIMATION_YDURATIO=100;
    //endregion

    public Fuel_Fragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fuel_, container, false);
        //region varaible init
        rb_diesel=(RadioButton)view.findViewById(R.id.diesel);
        rb_pdiesel=(RadioButton)view.findViewById(R.id.pdiesel);
        rb_90=(RadioButton)view.findViewById(R.id.ron90);
        rb_92=(RadioButton)view.findViewById(R.id.ron92);
        rb_95=(RadioButton)view.findViewById(R.id.ron95);

        barChart=(BarChart)view.findViewById(R.id.fuel_barchart);
        lineChart=(LineChart)view.findViewById(R.id.fuel_linechart);
        setOverAllData("abc",200f,100f,120f,300f,124f,390f,200f);
        //endregion

        rbarray=new RadioButton[]{rb_diesel,rb_pdiesel,rb_90,rb_92,rb_95};
        //set listener to radio button
        setOnClickListener();
        // Inflate the layout for this fragment
        return view;
    }

 private void setOnClickListener(){
     rb_diesel.setOnClickListener(this);
     rb_pdiesel.setOnClickListener(this);
     rb_90.setOnClickListener(this);
     rb_92.setOnClickListener(this);
     rb_95.setOnClickListener(this);
 }

    private void radioButtonProcessor(int id){
        for(int i=0;i<5;i++){
            if(radiobutton_id[i]!=id) {
                rbarray[i].setChecked(false);
            }
        }
    }

    @Override
    public void onClick(View v) {
        //to get button process
    radioButtonProcessor(v.getId());
        switch (v.getId()){
            case R.id.diesel :
                setOverAllData("Diesel",700f,690f,670f,699f,685f,710f,720f);
                break;
            case R.id.pdiesel:
                setOverAllData("Premium Diesel",720f,710f,700f,720f,730f,750f,740f);
                break;
            case R.id.ron90:
                setOverAllData("Octane 90Ron",650f,660f,665f,650f,640f,670f,660f);
                break;
            case R.id.ron92:
                setOverAllData("Octane 92Ron",700f,705f,700f,730f,725f,710f,730f);
                break;
            case R.id.ron95:
                setOverAllData("Octane 95Ron",730f,720f,725f,740f,735f,750f,760f);
        }
    }

    //region chart method
    private ArrayList<String> getXAxisLineChartValue(){
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
    //endregion

    private ArrayList<LineDataSet>getDataSetLineChart(float a, float b, float c, float d, float e,float f,float g,String name){
        ArrayList<LineDataSet> dataSets=null;
        LineDataSet SGD=new LineDataSet(setWeekData(a,b,c,d,e,f,g),name);
    //    SGD.setColor(Color.BLUE);
        SGD.setColors(ColorTemplate.JOYFUL_COLORS);
        dataSets=new ArrayList<>();
        dataSets.add(SGD);
        return dataSets;
    }

    private ArrayList<Entry> setWeekData(float f1, float f2, float f3, float f4, float f5, float f6, float f7){
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

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void setOverAllData(String dataName, float f1, float f2, float f3, float f4, float f5, float f6, float f7){
        lineChart.setDescription("");
        LineData lineData=new LineData(getXAxisLineChartValue(),getDataSetLineChart(f1,f2,f3,f4,f5,f6,f7,dataName));
        lineChart.setData(lineData);
        lineChart.animateXY(ANIMATION_XDURATION,ANIMATION_YDURATIO);
        lineChart.getLineData().setValueTextSize(10f);
        lineChart.getAxisLeft().setStartAtZero(false);
        lineChart.getAxisRight().setStartAtZero(false);
        lineChart.getAxisRight().setShowOnlyMinMax(true);
        lineChart.getAxisLeft().setShowOnlyMinMax(true);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);
        XAxis xAxis=lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.fitScreen();
    }

}
