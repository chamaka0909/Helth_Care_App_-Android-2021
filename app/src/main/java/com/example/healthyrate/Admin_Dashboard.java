package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_Dashboard extends AppCompatActivity implements View.OnClickListener {

    public CardView card1,card2,card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        card1 = (CardView)findViewById(R.id.adminadd);
        card2 = (CardView)findViewById(R.id.adminupdate);
        card3 = (CardView)findViewById(R.id.admindelete);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()){

            case R.id.adminadd:
                i = new Intent(this,Covid_Test_Result.class);
                startActivity(i);
                break;

            case R.id.adminupdate:
                i = new Intent(this,Update_Test_Result.class);
                startActivity(i);
                break;

            case R.id.admindelete:
                i = new Intent(this,Delete_Test_Report.class);
                startActivity(i);
                break;



        }

    }
}