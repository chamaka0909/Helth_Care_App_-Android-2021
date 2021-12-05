package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healthyrate.databinding.ActivityUpdateTestResultBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Update_Test_Result extends AppCompatActivity {

    ActivityUpdateTestResultBinding binding;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateTestResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ptid = binding.ptid.getText().toString();
                String ptname = binding.ptname.getText().toString();
                String ptstatus = binding.ptstatus.getText().toString();

                updatedata(ptid, ptname, ptstatus);
            }
        });
    }

    private void updatedata(String ptid, String ptname, String ptstatus) {

        HashMap Patient = new HashMap();
        Patient.put("ptname",ptname);
        Patient.put("ptstatus",ptstatus);
        databaseReference = FirebaseDatabase.getInstance().getReference("Covid_Test_Result");
        databaseReference.child(ptid).updateChildren(Patient).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull @NotNull Task task) {

                if (task.isSuccessful()){

                    binding.ptid.setText("");
                    binding.ptname.setText("");
                    binding.ptstatus.setText("");
                    Toast.makeText(Update_Test_Result.this,"Successfully Updated",Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(Update_Test_Result.this,"Failed to Update",Toast.LENGTH_SHORT).show();





                }

            }
        });

    }

}












