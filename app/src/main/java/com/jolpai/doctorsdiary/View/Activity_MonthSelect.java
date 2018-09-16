package com.jolpai.doctorsdiary.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.astuetz.PagerSlidingTabStrip;
import com.jolpai.doctorsdiary.Contractor.MonthSelection.MonthSelection_C;
import com.jolpai.doctorsdiary.Model.Worker.Others.AppColor;
import com.jolpai.doctorsdiary.Presenter.MonthSelection.MonthSelection_P;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.View.Report.Fragment_Report_MonthSelect;
import com.jolpai.doctorsdiary.View.plan.Fragment_Plan_MonthSelect;

import java.util.ArrayList;

import javax.inject.Inject;

public class Activity_MonthSelect extends AppCompatActivity
        implements MonthSelection_C.View{

    @Inject
    MonthSelection_P presenter;

    private AppCompatActivity activity;

    private ViewPager pager;
    private MyPagerAdapter adapter;
    PagerSlidingTabStrip tab;
    AppColor appColor ;
    public Toolbar toolbar;
    Spinner spnrYear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_selection);

        presenter = new MonthSelection_P(Activity_MonthSelect.this);
        presenter.intiView();
        presenter.populateYearSpinner();
        presenter.navigateToNextPage();
    }

    @Override
    public void initView() {
        appColor=presenter.getColorObject();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Doctor's Diary");

        spnrYear =(Spinner)findViewById(R.id.spnrYear);

        pager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tab = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tab.setViewPager(pager);

        tab.setIndicatorColor(appColor.getWhite());
        tab.setTextColor(appColor.getWhite());
        tab.setDividerColor(appColor.getWhite());
        tab.setUnderlineColor(appColor.getWhite());
        tab.setUnderlineHeight(1);
        tab.setIndicatorHeight(10);
        tab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    toolbar.setBackgroundColor(appColor.getBlue_500());
                    tab.setBackgroundColor(appColor.getBlue_500());
                }else if(position == 1){
                    toolbar.setBackgroundColor(appColor.getGreen_hangout());
                    tab.setBackgroundColor(appColor.getGreen_hangout());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void setSpinner(ArrayList<String> yearsList, int positionOfCurrentYear) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Activity_MonthSelect.this,
                android.R.layout.simple_spinner_item, yearsList);
        spnrYear.setAdapter(adapter);
        spnrYear.setSelection(positionOfCurrentYear);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.report_add_edit_comment_menu, menu);
        return true;
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS =3;
        private  String year="";
        public String mYear;
        private final String[] TITLES = { "Report", "Plan"};
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return Fragment_Report_MonthSelect.newInstance(year,"");
                case 1:
                    return Fragment_Plan_MonthSelect.newInstance(year,"");
                default:
                    return null;
            }
        }

        /**
         * Return the number of views available.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }
    }
}
