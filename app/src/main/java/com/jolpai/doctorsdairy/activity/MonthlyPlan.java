package com.jolpai.doctorsdairy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;

import com.jolpai.doctorsdairy.R;
import com.rey.material.widget.Spinner;

public class MonthlyPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_plan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        Spinner spn_label = (Spinner)findViewById(R.id.spinner_label);

        String[] items = new String[3];

            items[0] = "Participant";
            items[1] = "Volunteer";
            items[2] = "Member";


        ArrayAdapter<String> adapter = new ArrayAdapter<>(MonthlyPlan.this, R.layout.x_row_span, items);
        adapter.setDropDownViewResource(R.layout.x_row_spn_dropdown);
        spn_label.setAdapter(adapter);

    }
}
