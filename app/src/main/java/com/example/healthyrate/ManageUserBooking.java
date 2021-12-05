package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ManageUserBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user_booking);

        // Move to Manage Appointment Activity to Update Appointment Activity
        final Button appointment01 = findViewById(R.id.appointment01);
        appointment01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appointmentID = "-MkMYcAWcP25LRc5Xg9i";

                Intent intent1 = new Intent(ManageUserBooking.this,UpdateUserBooking.class);
                intent1.putExtra("appointmentID", appointmentID);
                startActivity(intent1);
            }
        });

    }
}