package com.jolpai.doctorsdiary.View.MonthSelection;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;
import com.jolpai.doctorsdiary.Contractor.MonthSelection.MonthSelection_C;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Worker.Others.AppColor;

/**
 * Created by User on 10/30/2017.
 */

public class ViewHelper implements MonthSelection_C.ViewHelper {


    private AppCompatActivity activity;

    private ViewPager pager;
    private MyPagerAdapter adapter;
    PagerSlidingTabStrip tab;
    AppColor appColor ;
    public   Toolbar toolbar;


    public ViewHelper (AppCompatActivity activity){
        this.activity=activity;
        appColor=AppColor.getInstance();
    }

    @Override
    public void intiPager() {

        toolbar = (Toolbar) activity.findViewById(R.id.my_toolbar);
        activity.setSupportActionBar(toolbar);
        pager = (ViewPager)activity.findViewById(R.id.viewPager);
        tab = (PagerSlidingTabStrip)activity.findViewById(R.id.tabs);

        adapter = new MyPagerAdapter(activity.getSupportFragmentManager());
        pager.setAdapter(adapter);

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
                    return MonthSelect_Report.newInstance("","");
                case 1:
                    return MonthSelect_Plan.newInstance("","");
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
