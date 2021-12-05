package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultFitness extends AppCompatActivity {

    TextView hhrate,tthrate,iiweight,bbmi,bbmr,bbfat,ssstatus;

    private static DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_fitness);

        hhrate = findViewById(R.id.txtmaxhr);
        tthrate = findViewById(R.id.txttargethr);
        iiweight = findViewById(R.id.txtidealww);
        bbmi = findViewById(R.id.txtbimm);
        bbmr = findViewById(R.id.txtbrmm);
        bbfat = findViewById(R.id.txtbfp);
        ssstatus=findViewById(R.id.txtstatus);


        String Hrate = getIntent().getStringExtra("Hrate");
        String THrate = getIntent().getStringExtra("THrate");
        String Iweight = getIntent().getStringExtra("Iweight");
        String Bmi = getIntent().getStringExtra("Bmi");
        String Bmr = getIntent().getStringExtra("Bmr");
        String Bfat = getIntent().getStringExtra("Bfat");
        String sStatus = getIntent().getStringExtra("sstatus");



        //String fff=df.format(Bfat);




        hhrate.setText(Hrate+" BPM");
        tthrate.setText(THrate +" BPM");
        iiweight.setText(Iweight +" Kg");
        bbmi.setText(Bmi);
        bbmr.setText(Bmr);
        bbfat.setText(Bfat+" %");
        ssstatus.setText(sStatus);

    }
}