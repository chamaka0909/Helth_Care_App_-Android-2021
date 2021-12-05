package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Covid_Test_Home extends AppCompatActivity implements View.OnClickListener {

    public CardView palg,adlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_test_home);
        palg = (CardView)findViewById(R.id.patientlog);
        adlg = (CardView)findViewById(R.id.adminlog);


       palg.setOnClickListener(this);
       adlg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()){

            case R.id.patientlog:
                i = new Intent(this,Patient_dashboard.class);
                startActivity(i);
                break;

            case R.id.adminlog:
                i = new Intent(this,Admin_Dashboard.class);
                startActivity(i);
                break;

                 }

    }
}