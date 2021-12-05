package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AddAppointment extends AppCompatActivity {

    EditText appoID, addName, addAge, addAddress, addConNo, addDate;
    Button btnCheckBook;
    DatabaseReference dbRef;
    Appointment appointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        String userID = "uid0001";
        String hName = "Nawaloka Hospital";
        String dName = "Dr. Namal Perera";

        appoID = findViewById(R.id.pt_appoID);
        addName = findViewById(R.id.pt_addName);
        addAge = findViewById(R.id.pt_addAge);
        addAddress = findViewById(R.id.pt_addAddress);
        addConNo = findViewById(R.id.pt_addConNo);
        addDate = findViewById(R.id.ed_addDate);

        appointment = new Appointment();

        final Button buttonInsert = findViewById(R.id.btn_checkBook);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Appointment");

                try {
                    if (TextUtils.isEmpty(addName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Patient Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(addAge.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter Patient Age", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(addAddress.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Address", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(addConNo.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Contact No", Toast.LENGTH_SHORT).show();
                    else {
                        appointment.setAppoID(appoID.getText().toString().trim());
                        appointment.setUserID(userID);
                        appointment.setHospitalName(hName);
                        appointment.setDoctorName(dName);
                        appointment.setPatientName(addName.getText().toString().trim());
                        appointment.setPatientAge(addAge.getText().toString().trim());
                        appointment.setPatientAddress(addAddress.getText().toString().trim());
                        appointment.setPatientConNo(addConNo.getText().toString().trim());
                        appointment.setBookingDate(addDate.getText().toString().trim());

                        dbRef.push().setValue(appointment);

                        Toast.makeText(getApplicationContext(), "Data saved Successfully", Toast.LENGTH_SHORT).show();

                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}