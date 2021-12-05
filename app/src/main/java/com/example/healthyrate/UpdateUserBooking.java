package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class UpdateUserBooking extends AppCompatActivity {

    EditText pt_patientName, pt_patientAge, pt_patientAddress, pt_patientConNo;
    Button btn_appoUpdate, btn_appoDelete;
    Appointment appointment;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_booking);

        pt_patientName = findViewById(R.id.pt_patientName);
        pt_patientAge = findViewById(R.id.pt_patientAge);
        pt_patientAddress = findViewById(R.id.pt_patientAddress);
        pt_patientConNo = findViewById(R.id.pt_patientConNo);

        btn_appoUpdate = findViewById(R.id.btn_appoUpdate);
        btn_appoDelete = findViewById(R.id.btn_appoDelete);

        appointment = new Appointment();


        // View Data
        String appointmentID = getIntent().getStringExtra("appointmentID");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Appointment").child(appointmentID);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    pt_patientName.setText(snapshot.child("patientName").getValue().toString());
                    pt_patientAge.setText(snapshot.child("patientAge").getValue().toString());
                    pt_patientAddress.setText(snapshot.child("patientAddress").getValue().toString());
                    pt_patientConNo.setText(snapshot.child("patientConNo").getValue().toString());
                }else {
                    Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


        // Update Details
        final Button btnUpdate = findViewById(R.id.btn_appoUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("Appointment");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(appointmentID)) {
                            try {
                                appointment.setPatientName(pt_patientName.getText().toString().trim());
                                appointment.setPatientAge(pt_patientAge.getText().toString().trim());
                                appointment.setPatientAddress(pt_patientAddress.getText().toString().trim());
                                appointment.setPatientConNo(pt_patientConNo.getText().toString().trim());

                                databaseReference = FirebaseDatabase.getInstance().getReference().child("Appointment").child(appointmentID);
                                databaseReference.setValue(appointment);

                                Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                            }catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
            }
        });


        // Delete Appointment
        final Button btnDelete = findViewById(R.id.btn_appoDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dlRef = FirebaseDatabase.getInstance().getReference().child("Appointment");
                dlRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        if (snapshot.hasChild(appointmentID)) {
                            databaseReference = FirebaseDatabase.getInstance().getReference().child("Appointment").child(appointmentID);
                            databaseReference.removeValue();
                            Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
            }
        });


    }
}