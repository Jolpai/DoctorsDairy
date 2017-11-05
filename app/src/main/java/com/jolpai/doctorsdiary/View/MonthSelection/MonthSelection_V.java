package com.jolpai.doctorsdiary.View.MonthSelection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jolpai.doctorsdiary.Contractor.MonthSelection.MonthSelection_C;
import com.jolpai.doctorsdiary.Presenter.MonthSelection.MonthSelection_P;
import com.jolpai.doctorsdiary.R;

import javax.inject.Inject;

public class MonthSelection_V extends AppCompatActivity implements MonthSelection_C.View{

    @Inject
    MonthSelection_P presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_selection);



        ViewHelper helper=new ViewHelper(MonthSelection_V.this);
        helper.intiPager();
        presenter.navigateToNextPage();

    }

    @Override
    public void initView() {

    }


}
