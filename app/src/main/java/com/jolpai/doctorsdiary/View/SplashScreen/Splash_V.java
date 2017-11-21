package com.jolpai.doctorsdiary.View.SplashScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.jolpai.doctorsdiary.Contractor.SplashScreen.Splash_C;
import com.jolpai.doctorsdiary.Presenter.SplashScreen.Splash_P;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.View.MonthSelection.MonthSelection_V;

import dagger.Binds;

public class Splash_V extends AppCompatActivity implements Splash_C.View{

    private Splash_C.Presenter prsenter;
    private Context mContext;
    @Binds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

      //  AppComponent component = DaggerAppC


        this.mContext=Splash_V.this;
        prsenter = new Splash_P(this);

    }

    @Override
    protected void onResume(){
        super.onResume();
        prsenter.navigateToHomePage();

    }

    @Override
    public void init() {

    }

    @Override
    public void displayApplicationMessage(String message) {

    }

    @Override
    public void navigateToHomePage(int time) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, MonthSelection_V.class);
                mContext.startActivity(intent);
                finish();
            }
        }, time);
    }
}
