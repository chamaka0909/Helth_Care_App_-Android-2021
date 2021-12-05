package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class labReport_retrive_data extends AppCompatActivity {


    ListView myListview;
    List<pData> pdatalist;

    DatabaseReference pdataDbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_report_retrive_data);


        myListview = findViewById(R.id.myListView);
        pdatalist = new ArrayList<>();

        pdataDbref = FirebaseDatabase.getInstance().getReference("pData");


        pdataDbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                pdatalist.clear();

                for (DataSnapshot Pdatasnap : snapshot.getChildren()){
                    pData pdata = Pdatasnap.getValue(pData.class);

                    pdatalist.add(pdata);

                }

                ListLadapter adapter = new ListLadapter(labReport_retrive_data.this,pdatalist);
                myListview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}