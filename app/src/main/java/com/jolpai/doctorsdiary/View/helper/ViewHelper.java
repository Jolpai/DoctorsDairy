package com.jolpai.doctorsdiary.View.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.astuetz.PagerSlidingTabStrip;
import com.jolpai.doctorsdiary.Contractor.MonthSelection.MonthSelection_C;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Model.Worker.Others.AppColor;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by User on 10/30/2017.
 */

public class ViewHelper {


    private AppCompatActivity activity;

    private ViewPager pager;
    PagerSlidingTabStrip tab;
    AppColor appColor ;
    public   Toolbar toolbar;
    Spinner spnrYear;


    public ViewHelper (AppCompatActivity activity){
        this.activity=activity;

    }

    public  String getSelectedYear(){
        return spnrYear.getSelectedItem().toString();
    }



    public interface OnSpinnerSelectedListener {
        void onItemSelected();
    }


}
