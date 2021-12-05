package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ManageUserBookingNew extends AppCompatActivity {

    RecyclerView recyclerView;
    ManageAppointmentAdapter manageAppointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user_booking_new);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Appointment> options =
                new FirebaseRecyclerOptions.Builder<Appointment>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Appointment"), Appointment.class)
                        .build();

        manageAppointmentAdapter = new ManageAppointmentAdapter(options);
        recyclerView.setAdapter(manageAppointmentAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        manageAppointmentAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        manageAppointmentAdapter.stopListening();
    }
}