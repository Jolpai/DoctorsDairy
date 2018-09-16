package com.jolpai.doctorsdiary.Contractor.MonthSelection;

import com.jolpai.doctorsdiary.Model.Worker.Others.AppColor;

import java.util.ArrayList;

/**
 * Created by User on 10/30/2017.
 */

public interface MonthSelection_C {
    interface View{
        void initView();
        void setSpinner(ArrayList<String> yearsList, int positionOfCurrentYear);
    }

    interface Presenter{
        void intiView();
        void populateYearSpinner();
        void blinkCurrentMonth();
        void setMonthName();
        AppColor getColorObject();
        void setTab_ToolbarColor(AppColor appColor);
        void navigateToNextPage();
    }

    interface Model{
        void getMonthName();
        AppColor getColorObject();
        ArrayList<String> getListOfYear();
    }
}
