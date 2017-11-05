package com.jolpai.doctorsdiary.Contractor.MonthSelection;

/**
 * Created by User on 10/30/2017.
 */

public interface MonthSelection_C {
    interface View{
        void initView();

    }

    interface ViewHelper{
        void intiPager();
    }

    interface Presenter{
        void blinkCurrentMonth();
        void setMonthName();
        void setColor();
        void navigateToNextPage();
    }

    interface Model{
        void getMonthName();
        void getColor();
    }
}
