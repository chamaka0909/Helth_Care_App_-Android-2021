package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class allHome extends AppCompatActivity {
    private Button labreport,fitness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_home);


        fitness =(Button)findViewById(R.id.fitfit);
        labreport=(Button)findViewById(R.id.llreport);




        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openefitness();
            }
        });




        labreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlab();
            }
        });



    }


    public void openefitness(){
        Intent intent = new Intent(this, connectFitness.class);
        startActivity(intent);
    }



    public void openlab(){
        Intent intent = new Intent(this, appointment_lab.class);
        startActivity(intent);
    }
}