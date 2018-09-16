package com.jolpai.doctorsdiary.Model.MonthSelection;

import com.jolpai.doctorsdiary.Contractor.MonthSelection.MonthSelection_C;
import com.jolpai.doctorsdiary.Model.Worker.Others.AppColor;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by User on 1/16/2018.
 */

public class MonthSelection_M implements MonthSelection_C.Model {

   private MonthSelection_C.Presenter presenter;

   public MonthSelection_M(MonthSelection_C.Presenter presenter){
       this.presenter=presenter;
   }

    @Override
    public void getMonthName() {

    }

    @Override
    public AppColor getColorObject() {
       return AppColor.getInstance();
    }

    @Override
    public ArrayList<String> getListOfYear() {
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        int maxYearLimit = thisYear+5;
        for (int i = 2015; i <= maxYearLimit; i++) {
            years.add(Integer.toString(i));
        }
        return years;
    }
}
