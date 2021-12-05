package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthyrate.databinding.ActivityCovidTestResultBinding;
import com.example.healthyrate.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Covid_Test_Result extends AppCompatActivity {

  ActivityCovidTestResultBinding binding;
   String ptid,ptname,ptstatus;
   FirebaseDatabase db;
   DatabaseReference reference;
   Button btnsave;
   EditText patid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCovidTestResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    binding.btnsave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ptid = binding.ptid.getText().toString();
            ptname = binding.ptname.getText().toString();
            ptstatus = binding.ptstatus.getText().toString();

            if (!ptid.isEmpty() && !ptname.isEmpty() && !ptstatus.isEmpty() ){

                Result result = new Result(ptid,ptname,ptstatus);
                db = FirebaseDatabase.getInstance();
                reference = db.getReference("Covid_Test_Result");
                reference.child(ptid).setValue(result).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {

                        binding.ptid.setText("");
                        binding.ptname.setText("");
                        binding.ptstatus.setText("");
                        Toast.makeText(Covid_Test_Result.this,"Successfuly Saved",Toast.LENGTH_SHORT).show();

                    }
                });
            }

        }
    });

        btnsave = findViewById(R.id.btnsave);
        patid = findViewById(R.id.ptid);


        patid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (validatepatientid(patid.getText().toString())) {

                    btnsave.setEnabled(true);
                } else
                    btnsave.setEnabled(false);
                patid.setError("Invalid patient IDr");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    boolean validatepatientid (String input){

        Pattern p = Pattern.compile("P[0-9]{4}");
        Matcher m = p.matcher(input);
        return m.matches();
    }
}