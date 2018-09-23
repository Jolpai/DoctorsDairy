package com.jolpai.doctorsdiary.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.jolpai.doctorsdiary.Contractor.SplashScreen.Splash_C;
import com.jolpai.doctorsdiary.Presenter.SplashScreen.Splash_P;
import com.jolpai.doctorsdiary.R;

public class Activity_Splash extends AppCompatActivity implements Splash_C.View{

    private Splash_C.Presenter presenter;
    private Context mContext;
    //@Binds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.mContext=Activity_Splash.this;
        presenter = new Splash_P(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        presenter.navigateToHomePage();
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
                Intent intent = new Intent(mContext, Activity_MonthSelect.class);
                //Intent intent = new Intent(mContext, Test.class);
                mContext.startActivity(intent);
                finish();
            }
        }, time);
    }
}
