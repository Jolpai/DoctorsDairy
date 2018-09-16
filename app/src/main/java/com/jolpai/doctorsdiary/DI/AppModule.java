package com.jolpai.doctorsdiary.DI;

import android.app.Application;
import android.content.Context;

import com.jolpai.doctorsdiary.Presenter.SplashScreen.Splash_P;
import com.jolpai.doctorsdiary.View.Activity_Splash;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 11/18/2017.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule (Application application){
        this.context =application;
    }

    @Provides
    public Context providesContext(){
        return context;
    }


    @Provides @Singleton
    Splash_P provideSplash_P( Activity_Splash view){
        return new Splash_P(view);
    }
}
