package com.jolpai.doctorsdiary.IO.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.IO.fragment.ReportAddEdit;
import com.jolpai.doctorsdiary.IO.fragment.CommentOnReport;
import com.jolpai.doctorsdiary.Worker.IntParser;

public class ReportAddEditComment extends AppCompatActivity {
    FragmentPagerAdapter pagerAdapter;
    private PagerSlidingTabStrip tab;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    public static int  year,month,day;

    private int toolbarColor,toolbarTextColor,white,amber_500,green_500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_add_edit_comment);

        white=ReportAddEditComment.this.getResources().getColor(R.color.white);
        amber_500=ReportAddEditComment.this.getResources().getColor(R.color.amber_500);
        green_500=ReportAddEditComment.this.getResources().getColor(R.color.green_500);

        toolbarColor=green_500;
        toolbarTextColor=white;

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        pager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
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

        Intent intent = this.getIntent();;
        year= IntParser.parseStrToInt(intent.getStringExtra("year"));
        month=IntParser.parseStrToInt(intent.getStringExtra("month"));
        day=IntParser.parseStrToInt(intent.getStringExtra("day"));

    }



    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS =3;
        private final String[] TITLES = { "Add/Edit", "Comment"};
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
                    return ReportAddEdit.newInstance(year,month,day);
                case 1:
                    return CommentOnReport.newInstance(0,"");
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
