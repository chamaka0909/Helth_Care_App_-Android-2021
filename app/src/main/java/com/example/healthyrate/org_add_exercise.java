package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class org_add_exercise extends AppCompatActivity {

    private static final String TAG = "org_add_exercise";

    EditText description;
    TextView date,from,to;
    Button btneadd,btnback;
    DatabaseReference dbRef;
    orgExer exerObj;
    DatePickerDialog.OnDateSetListener dateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_add_exercise);



        date = (TextView) findViewById(R.id.txtDate);
        from = (TextView) findViewById(R.id.txtfrom);
        to = (TextView) findViewById(R.id.txtto);
        description = (EditText)findViewById(R.id.txtdes);
        btneadd = (Button) findViewById(R.id.btnAdd);
        btnback= (Button) findViewById(R.id.btnBack);



//time from
        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(org_add_exercise.this, R.style.Theme_HealthyRate, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                        String time = format.format(c.getTime());

                        from.setText(time);
                    }
                },hours,mins,false);
                timePickerDialog.show();
            }
        });




//time to
        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(org_add_exercise.this, R.style.Theme_HealthyRate, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                        String time = format.format(c.getTime());

                        to.setText(time);
                    }
                },hours,mins,false);
                timePickerDialog.show();
            }
        });











        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(org_add_exercise.this,
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




        btneadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearControls();

            }
        });


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }







    private void insertData(){


        if (TextUtils.isEmpty(date.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Date", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(from.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Time", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(to.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Time", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(description.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Description", Toast.LENGTH_SHORT).show();
        }else {


            Map<String, Object> map = new HashMap<>();
            map.put("date", date.getText().toString());
            map.put("from", from.getText().toString());
            map.put("to", to.getText().toString());
            map.put("description", description.getText().toString());


            FirebaseDatabase.getInstance().getReference().child("eeData").push()
                    .setValue(map)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(org_add_exercise.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(org_add_exercise.this, "Error while Insertion.", Toast.LENGTH_SHORT).show();
                        }
                    });


        }












    }


    private void clearControls() {
        date.setText("");
        from.setText("");
        to.setText("");
        description.setText("");


    }



}