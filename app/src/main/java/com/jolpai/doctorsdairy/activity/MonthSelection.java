package com.jolpai.doctorsdairy.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;
import com.jolpai.doctorsdairy.R;
import com.jolpai.doctorsdairy.fragment.CommentOnReport;
import com.jolpai.doctorsdairy.fragment.MonthForPlan;
import com.jolpai.doctorsdairy.fragment.MonthForReport;
import com.jolpai.doctorsdairy.fragment.ReportAddEdit;

public class MonthSelection extends AppCompatActivity {

    private Context context;
    private Activity activity;

    private PagerSlidingTabStrip tab;
    private ViewPager pager;
    private MonthSelection.MyPagerAdapter adapter;

    private int toolbarColor,toolbarTextColor,white,amber_500,green_500,blue_500;
    public  static
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_selection);
        this.context=MonthSelection.this;
        this.activity=MonthSelection.this;


        white=context.getResources().getColor(R.color.white);
        amber_500=context.getResources().getColor(R.color.amber_500);
        green_500=context.getResources().getColor(R.color.green_500);
        blue_500=context.getResources().getColor(R.color.blue_500);

        toolbarColor=green_500;
        toolbarTextColor=white;

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        pager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new MonthSelection.MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);


        // Bind the tabs to the ViewPager
        tab = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tab.setViewPager(pager);

        tab.setIndicatorColor(white);
        tab.setTextColor(white);
        tab.setDividerColor(white);
        tab.setUnderlineColor(white);
        tab.setUnderlineHeight(1);
        tab.setIndicatorHeight(10);
        tab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    toolbar.setBackgroundColor(blue_500);
                    tab.setBackgroundColor(blue_500);
                }else if(position == 1){
                    toolbar.setBackgroundColor(green_500);
                    tab.setBackgroundColor(green_500);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS =3;
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
                    return MonthForReport.newInstance("","");
                case 1:
                    return MonthForPlan.newInstance("","");
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
