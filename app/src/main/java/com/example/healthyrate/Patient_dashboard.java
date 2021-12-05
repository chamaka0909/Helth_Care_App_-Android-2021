package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Patient_dashboard extends AppCompatActivity implements View.OnClickListener {

    public CardView cardv1,cardv2,cardv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        cardv1 = (CardView)findViewById(R.id.addappoinment);
        cardv2 = (CardView)findViewById(R.id.searchresult);
        cardv3 = (CardView)findViewById(R.id.checkoxygen);

        cardv1.setOnClickListener(this);
        cardv2.setOnClickListener(this);
        cardv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()){

            case R.id.addappoinment:
                i = new Intent(this,Covid_Test_Appointment.class);
                startActivity(i);
                break;

            case R.id.searchresult:
                i = new Intent(this,Search_Test_Result.class);
                startActivity(i);
                break;

            case R.id.checkoxygen:
                i = new Intent(this,Oxygen_level_calculate.class);
                startActivity(i);
                break;



        }

    }
}