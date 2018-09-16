package com.jolpai.doctorsdiary.DI;

import com.jolpai.doctorsdiary.View.Activity_Splash;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by User on 11/18/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {


   // Splash_C.Presenter provideSplash_P();

    void inject(Activity_Splash view);


}
