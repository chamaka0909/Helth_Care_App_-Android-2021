package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HospitalList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    HospitalAdapter hpAdapter;
    ArrayList<HospitalProvince> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);

        // Get user selected province button
        String province = getIntent().getStringExtra("userProvince");

        recyclerView = findViewById(R.id.hospitalList);
        databaseReference  = FirebaseDatabase.getInstance().getReference("HospitalProvince");
        Query dbQuery = databaseReference.orderByChild("province").equalTo(province);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        hpAdapter = new HospitalAdapter(this,list);
        recyclerView.setAdapter(hpAdapter);

        dbQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    HospitalProvince user = dataSnapshot.getValue(HospitalProvince.class);
                    list.add(user);
                }
                hpAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }
}