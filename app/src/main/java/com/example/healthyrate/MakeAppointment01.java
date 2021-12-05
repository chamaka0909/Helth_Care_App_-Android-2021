package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakeAppointment01 extends AppCompatActivity {

    private Button viewButtonCentral, viewButtonEastern;
    private Button btnDoctorNext01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_appointment01);

        // Insert Hospitals to the Database
        final Button btn_AddHospital = findViewById(R.id.btn_adminAddHospital);
        btn_AddHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertHospitalToDB();
            }
        });

        // Move to View Hospitals Activity - Central
        viewButtonCentral = findViewById(R.id.btn_central);

        viewButtonCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userProvince = "Central";

                Intent intent = new Intent(MakeAppointment01.this, HospitalList.class);
                intent.putExtra("userProvince", userProvince);
                startActivity(intent);
            }
        });

        // Move to View Hospitals Activity - Eastern
        viewButtonEastern = findViewById(R.id.btn_eastern);

        viewButtonEastern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userProvince = "Eastern";

                Intent intent = new Intent(MakeAppointment01.this, HospitalList.class);
                intent.putExtra("userProvince", userProvince);
                startActivity(intent);
            }
        });

        // Move to DoctorList Activity
        btnDoctorNext01 = findViewById(R.id.btnBookDoctor);
        btnDoctorNext01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doctorHospital = "Nawaloka Hospital";
                String hospitalID = "wp0001";

                Intent intent1 = new Intent(MakeAppointment01.this, DoctorList.class);
                intent1.putExtra("doctorHospital", doctorHospital);
                intent1.putExtra("hospitalID", hospitalID);
                startActivity(intent1);
            }
        });

    }

    // Move to Insert Hospital Activity
    public void insertHospitalToDB(){
        Intent intent = new Intent(this, TestAppointmentInsert.class);
        startActivity(intent);
    }

}