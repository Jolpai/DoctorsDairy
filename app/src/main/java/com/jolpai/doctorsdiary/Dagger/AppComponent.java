package com.jolpai.doctorsdiary.Dagger;

import com.jolpai.doctorsdiary.Contractor.SplashScreen.Splash_C;
import com.jolpai.doctorsdiary.Presenter.MonthSelection.MonthSelection_P;
import com.jolpai.doctorsdiary.Presenter.SplashScreen.Splash_P;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by User on 11/18/2017.
 */


public interface AppComponent {

    Splash_C.Presenter provideSplash_P();


}
