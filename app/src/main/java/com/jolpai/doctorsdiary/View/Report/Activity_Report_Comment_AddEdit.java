package com.jolpai.doctorsdiary.View.Report;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.astuetz.PagerSlidingTabStrip;
import com.jolpai.doctorsdiary.Model.Worker.Others.AppColor;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Model.Worker.Parse.IntParser;
import com.jolpai.doctorsdiary.Model.Worker.Parse.StrParser;

public class Activity_Report_Comment_AddEdit extends AppCompatActivity {
    FragmentPagerAdapter pagerAdapter;
    private PagerSlidingTabStrip tab;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    public static int  year,month,day;
    AppColor appColor ;

    Button btnSave;
    Toolbar toolbar;

    private int toolbarColor,toolbarTextColor,white,amber_500,green_500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_add_edit_comment);
        appColor=AppColor.getInstance();



        white=Activity_Report_Comment_AddEdit.this.getResources().getColor(R.color.white);
        amber_500=Activity_Report_Comment_AddEdit.this.getResources().getColor(R.color.amber_500);
        green_500=Activity_Report_Comment_AddEdit.this.getResources().getColor(R.color.green_500);

        toolbarColor=green_500;
        toolbarTextColor=white;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSave =(Button) toolbar.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewPager + ":" + pager.getCurrentItem());
                // based on the current position you can then cast the page to the correct
                // class and call the method:

                int m=pager.getCurrentItem();
                if (pager.getCurrentItem() == 0 && page != null) {
                    ((Fragment_Report_AddEdit)page).save();
                }else{
                     ((Fragment_Comment_AddEdit)page).save();
                    ((Fragment_Comment_AddEdit)page).clear();
                }
            }
        });


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
                    btnSave.setText("Save");
                    Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewPager + ":" + pager.getCurrentItem());

                    ((Fragment_Comment_AddEdit)page).clear();

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Intent intent = this.getIntent();
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
                    return Fragment_Report_AddEdit.newInstance(StrParser.parseIntToString(year),
                            StrParser.parseIntToString(month),
                            StrParser.parseIntToString(day));
                case 1:

                    return Fragment_Comment_AddEdit.newInstance(StrParser.parseIntToString(year),
                            StrParser.parseIntToString(month),
                            StrParser.parseIntToString(day));

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
