package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorList extends AppCompatActivity {

    private Button btnBookDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        // Move to AddAppointment Activity
        btnBookDoctor = findViewById(R.id.btnBookDoctor);
        btnBookDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DoctorList.this, AddAppointment.class);
                startActivity(intent1);
            }
        });
    }
}