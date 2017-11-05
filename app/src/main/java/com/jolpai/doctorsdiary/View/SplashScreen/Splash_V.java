package com.jolpai.doctorsdiary.View.SplashScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jolpai.doctorsdiary.Contractor.SplashScreen.Splash_C;
import com.jolpai.doctorsdiary.Presenter.SplashScreen.Splash_P;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.View.MonthSelection.MonthSelection_V;

import static com.jolpai.doctorsdiary.App.TAG;
import static com.jolpai.doctorsdiary.App.currentTime;

public class Splash_V extends AppCompatActivity implements Splash_C.View{

    private Splash_P prsenter;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.mContext=Splash_V.this;
        prsenter = new Splash_P(this);
        prsenter.navigateToHomePage();

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
                Log.e(TAG, currentTime());
            }
        }, time);
    }
}
