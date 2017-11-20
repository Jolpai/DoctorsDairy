package com.jolpai.doctorsdiary.Contractor.SplashScreen;

/**
 * Created by User on 10/28/2017.
 */

public interface Splash_C {

    interface View{
        void init();
        void displayApplicationMessage(String message);
        void navigateToHomePage(int time);
    }

    interface Presenter{
        void navigateToHomePage();
        void skipTheMessage();
        void getDisplayApplicationMessage();
    }

    interface Model{

    }
}
