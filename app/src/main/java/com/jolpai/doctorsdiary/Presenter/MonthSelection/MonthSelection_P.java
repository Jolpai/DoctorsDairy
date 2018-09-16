package com.jolpai.doctorsdiary.Presenter.MonthSelection;

import com.jolpai.doctorsdiary.Contractor.MonthSelection.MonthSelection_C;
import com.jolpai.doctorsdiary.Model.MonthSelection.MonthSelection_M;
import com.jolpai.doctorsdiary.Model.Worker.Others.AppColor;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;

import javax.inject.Inject;

/**
 * Created by User on 10/30/2017.
 */


public class MonthSelection_P implements MonthSelection_C.Presenter {

    private MonthSelection_C.View view;
    private  MonthSelection_C.Model model;


    @Inject
    public MonthSelection_P (MonthSelection_C.View view){
        this.view=view;
        model = new MonthSelection_M(this);

    }
    public MonthSelection_P(MonthSelection_C.Model model){
        this.model=model;
    }

    @Override
    public void intiView() {
        view.initView();
    }

    @Override
    public void populateYearSpinner() {
        ArrayList<String> yearsList = model.getListOfYear();
        int positionOfCurrentYear =getPositionOfCurrentYear(yearsList,Calendar.getInstance().get(Calendar.YEAR));
        view.setSpinner(yearsList,positionOfCurrentYear);

    }
    private int getPositionOfCurrentYear(ArrayList<String> yearList, int currentYear){
        return yearList.indexOf(""+currentYear);
    }

    @Override
    public void setTab_ToolbarColor(AppColor appColor){

    }

    @Override
    public void blinkCurrentMonth() {

    }

    @Override
    public void setMonthName() {

    }

    @Override
    public AppColor getColorObject() {
        return model.getColorObject();
    }

    @Override
    public void navigateToNextPage() {

    }
}
