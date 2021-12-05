package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class org_Exercise_new extends AppCompatActivity {

    private static final String TAG = "org_Exercise_new";

    EditText from,to,description;
    TextView date;
    Button btneadd,btneshow;
    DatabaseReference dbRef;
    orgExer exerObj;
    DatePickerDialog.OnDateSetListener dateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_exercise_new);

        date = (TextView) findViewById(R.id.txtdatee);
        from = findViewById(R.id.txtfromm);
        to = findViewById(R.id.editTextTime2);
        description = findViewById(R.id.txtsm);
        btneadd = findViewById(R.id.btnadde);
        btneshow= findViewById(R.id.button5);



        exerObj = new orgExer();


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(org_Exercise_new.this,
                        android.R.style.Theme_Holo_Light_Dialog,
                        dateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();

            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1;
                Log.d(TAG,"onDateSet: date:" +year+"/"+month+"/"+day);
                String ddate = month+"/"+day+"/"+year;
                date.setText(ddate);


            }
        };



    }


    private void clearControls() {
        date.setText("");
        from.setText("");
        to.setText("");
        description.setText("");


    }




    public void saveData(View view){
      // dbRef = FirebaseDatabase.getInstance().getReference().child("eeData");


        if (TextUtils.isEmpty(date.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(from.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(to.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(description.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
        }else {


            //new
            /*
            Bundle bundle1=getIntent().getExtras();
            if(bundle1 !=null){
                String id = uDate;
                updateToex()
            }

             */


/*
            exerObj.setDate(date.getText().toString().trim());
            exerObj.setFrom(from.getText().toString().trim());
            exerObj.setTo(to.getText().toString().trim());
            exerObj.setDescription(description.getText().toString().trim());

 */
            Map<String,Object> map = new HashMap<>();
            map.put("date",date.getText().toString());
            map.put("from",from.getText().toString());
            map.put("to",to.getText().toString());
            map.put("description",description.getText().toString());


            FirebaseDatabase.getInstance().getReference().child("eeData").push()
                    .setValue(map)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(org_Exercise_new.this,"Data Inserted Successfully.",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(org_Exercise_new.this,"Error while Insertion.",Toast.LENGTH_SHORT).show();
                        }
                    });




            //dbRef.push().setValue(exerObj);
            //dbRef.child("LabappointmentData").setValue(exerObj);

           // Toast.makeText(getApplicationContext(), "Add New Exercise SuccessFully", Toast.LENGTH_SHORT).show();
            clearControls();





        }





    }







}