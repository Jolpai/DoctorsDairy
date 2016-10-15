package com.jolpai.doctorsdairy.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jolpai.doctorsdairy.App;
import com.jolpai.doctorsdairy.R;

import static com.jolpai.doctorsdairy.App.TAG;
import static com.jolpai.doctorsdairy.App.currentTime;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.e(App.TAG,"Splash");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MonthSelection.class);
                startActivity(intent);
                finish();
                Log.e(TAG, currentTime());
            }
        }, 500);


    }
}
