package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class connectFitness extends AppCompatActivity {
    private Button exbutton,calfit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_fitness);

        exbutton = (Button) findViewById(R.id.sheduleex);
        calfit = (Button) findViewById(R.id.calfitness);


        exbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openexshedule();
            }
        });




        calfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencalact();
            }
        });

    }
    public void openexshedule(){
        Intent intent = new Intent(this, org_Exer_show.class);
        startActivity(intent);
    }




    public void opencalact(){
        Intent intent=new Intent(this,CalculateFitness.class);
        startActivity(intent);
    }
}