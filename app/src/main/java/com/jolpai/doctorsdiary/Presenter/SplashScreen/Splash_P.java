package com.jolpai.doctorsdiary.Presenter.SplashScreen;

import com.jolpai.doctorsdiary.Contractor.SplashScreen.Splash_C;

/**
 * Created by User on 10/28/2017.
 */

public class Splash_P implements Splash_C.Presenter {

    private final Splash_C.View view;

    public Splash_P(Splash_C.View view){
        this.view = view;
    }

    @Override
    public void navigateToHomePage() {
        view.navigateToHomePage(5000);
    }

    @Override
    public void skipTheMessage() {

    }

    @Override
    public void getDisplayApplicationMessage() {
        view.displayApplicationMessage("Hello Sir");
    }
}
