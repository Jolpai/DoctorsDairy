package com.jolpai.doctorsdiary.View.helper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jolpai.doctorsdiary.View.plan.Fragment_Plan_MonthSelect;
import com.jolpai.doctorsdiary.View.Report.Fragment_Report_MonthSelect;

/**
 * Created by User on 1/16/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS =3;
    private  String year="";
    public String mYear;
    private final String[] TITLES = { "Report", "Plan"};
    public PagerAdapter(FragmentManager fm) {
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
                return Fragment_Report_MonthSelect.newInstance("","");
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
