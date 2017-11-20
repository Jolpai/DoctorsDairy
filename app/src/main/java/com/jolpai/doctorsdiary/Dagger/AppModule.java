package com.jolpai.doctorsdiary.Dagger;

import com.jolpai.doctorsdiary.Presenter.SplashScreen.Splash_P;
import com.jolpai.doctorsdiary.View.SplashScreen.Splash_V;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 11/18/2017.
 */

@Module
public class AppModule {

    @Provides @Singleton
    Splash_P provideSplash_P(){
        return new Splash_P(new Splash_V());
    }
}
