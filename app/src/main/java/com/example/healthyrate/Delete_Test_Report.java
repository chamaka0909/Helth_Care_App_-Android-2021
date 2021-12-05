package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.healthyrate.databinding.ActivityDeleteTestReportBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class Delete_Test_Report extends AppCompatActivity {


    ActivityDeleteTestReportBinding binding;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeleteTestReportBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.deletedataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ptid = binding.delptid.getText().toString();

                if(!ptid.isEmpty()){

                    deleteData(ptid);
                }else {

                    Toast.makeText(Delete_Test_Report.this,"Please Enter Patient ID",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

        private  void deleteData(String ptid){


            reference = FirebaseDatabase.getInstance().getReference("Covid_Test_Result");
            reference.child(ptid).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<Void> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(Delete_Test_Report.this,"Successfuly Deleted",Toast.LENGTH_SHORT).show();
                        binding.delptid.setText("");


                    }else {

                        Toast.makeText(Delete_Test_Report.this,"Failed",Toast.LENGTH_SHORT).show();


                    }
                }
            });
    }
}