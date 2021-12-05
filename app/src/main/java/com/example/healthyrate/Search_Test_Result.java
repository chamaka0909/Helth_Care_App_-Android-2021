package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healthyrate.databinding.ActivitySearchTestResultBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class Search_Test_Result extends AppCompatActivity {

    ActivitySearchTestResultBinding binding;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySearchTestResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.readdataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  ptid = binding.sptid.getText().toString();
                if(!ptid.isEmpty()){

                    readData(ptid);
                }
                else{

                    Toast.makeText(Search_Test_Result.this,"PLease Enter Patient ID",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void readData(String ptid) {

        reference = FirebaseDatabase.getInstance().getReference("Covid_Test_Result");
        reference.child(ptid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<DataSnapshot> task) {

                if (task.isSuccessful()) {

                    if (task.getResult().exists()) {

                        Toast.makeText(Search_Test_Result.this,"Successfully Searched",Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String ptid = String.valueOf(dataSnapshot.child("ptid").getValue());
                        String ptname = String.valueOf(dataSnapshot.child("ptname").getValue());
                        String ptstatus = String.valueOf(dataSnapshot.child("ptstatus").getValue());
                        binding.tvptid.setText(ptid);
                        binding.tvptname.setText(ptname);
                        binding.tvptstatus.setText(ptstatus);


                    }else {

                        Toast.makeText(Search_Test_Result.this,"Patient Report Doesn't Exist",Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(Search_Test_Result.this,"Failed to Search ",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}