package com.example.healthyrate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class appointment_lab extends AppCompatActivity {

    private static final String TAG = "appointment_lab";

    EditText nic, name, gender, age, blood, diseases, connum;
    TextView date,time;
    Button btnadd, btnshow, btnupdate, btndelete;
    DatabaseReference dbRef;
    patientSS patObj;
    DatePickerDialog.OnDateSetListener dateSetListener;
    //RadioButton male, female;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_lab);


        nic = findViewById(R.id.txtnic);
        name =findViewById(R.id.txtname);
        date = (TextView) findViewById(R.id.txtdatell);
        time = (TextView) findViewById(R.id.txttimel);
        age = findViewById(R.id.txtagel);
        blood = findViewById(R.id.txtblood);
        diseases = findViewById(R.id.txtsuf);
        connum = findViewById(R.id.txtcon);
        btnadd = findViewById(R.id.btnaddap);
        //male = findViewById(R.id.radb1);
        //female = findViewById(R.id.radb2);
        btnshow = findViewById(R.id.button2);
        btnupdate = findViewById(R.id.button3);
        btndelete = findViewById(R.id.button3);




        patObj = new patientSS();

        //new
        nic.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(validatenic(nic.getText().toString())){
                    btnadd.setEnabled(true);
                }
                else {
                    btnadd.setEnabled(false);
                    nic.setError("Invalid");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //end
        nic.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(validatenic(nic.getText().toString())){
                    btnupdate.setEnabled(true);
                }
                else {
                    btnupdate.setEnabled(false);
                    nic.setError("Invalid");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





        //end






        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(appointment_lab.this,
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







        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(appointment_lab.this, R.style.Theme_HealthyRate, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                        String timee = format.format(c.getTime());

                        time.setText(timee);
                    }
                },hours,mins,false);
                timePickerDialog.show();
            }
        });










    }
    //new
    boolean validatenic(String input){
        Pattern p =Pattern.compile("[0-9]{9}V");
        Matcher m = p.matcher(input);
        return m.matches();
    }






    private void clearControls() {
        nic.setText("");
        name.setText("");
        date.setText("");
        time.setText("");
        age.setText("");
        blood.setText("");
        diseases.setText("");
        connum.setText("");
    }



    public void CreateData(View view){



        dbRef = FirebaseDatabase.getInstance().getReference().child("ssData");



        if (TextUtils.isEmpty(nic.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an NIC", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(name.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Name", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(date.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Date", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(age.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Age", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(blood.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Blood Group", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(diseases.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Diseases", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(connum.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Contact Number", Toast.LENGTH_SHORT).show();
        }else {









                patObj.setNic(nic.getText().toString().trim());
                patObj.setName(name.getText().toString().trim());
                patObj.setDate(date.getText().toString().trim());
                patObj.setTime(time.getText().toString().trim());
                patObj.setAge(age.getText().toString().trim());
                patObj.setBlood(blood.getText().toString().trim());
                patObj.setDiseases(diseases.getText().toString().trim());
                patObj.setConnum(connum.getText().toString().trim());


                //dbRef.push().setValue(patObj);
            dbRef.child("LabappointmentData").setValue(patObj);

                Toast.makeText(getApplicationContext(), "Add Appontment SuccessFully", Toast.LENGTH_SHORT).show();
                clearControls();
            }



    }






    public void showData(View view){
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("ssData").child("LabappointmentData");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()){
                    nic.setText(snapshot.child("nic").getValue().toString());
                    name.setText(snapshot.child("name").getValue().toString());
                    date.setText(snapshot.child("date").getValue().toString());
                    time.setText(snapshot.child("time").getValue().toString());
                    age.setText(snapshot.child("age").getValue().toString());
                    blood.setText(snapshot.child("blood").getValue().toString());
                    diseases.setText(snapshot.child("diseases").getValue().toString());
                    connum.setText(snapshot.child("connum").getValue().toString());

                }
                else{
                    Toast.makeText(getApplicationContext(),"No Source to Display",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }


    public void update(View view){
        DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("ssData");
        upRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if(snapshot.hasChild("LabappointmentData")){

                    patObj.setNic(nic.getText().toString().trim());
                    patObj.setName(name.getText().toString().trim());
                    patObj.setDate(date.getText().toString().trim());
                    patObj.setTime(time.getText().toString().trim());
                    patObj.setAge(age.getText().toString().trim());
                    patObj.setBlood(blood.getText().toString().trim());
                    patObj.setDiseases(diseases.getText().toString().trim());
                    patObj.setConnum(connum.getText().toString().trim());


                    dbRef = FirebaseDatabase.getInstance().getReference().child("ssData").child("LabappointmentData");
                    dbRef.setValue(patObj);
                    clearControls();

                    Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Not Updated", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }





    public void deleteData(View view){
        DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("ssData");
        delRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.hasChild("LabappointmentData")){
                    dbRef=FirebaseDatabase.getInstance().getReference().child("ssData").child("LabappointmentData");
                    dbRef.removeValue();
                    clearControls();
                    Toast.makeText(getApplicationContext(),"Deleted Appointment Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"No Data here", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });



    }



       /* dbRef = FirebaseDatabase.getInstance().getReference().child("pData");
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPdata();
            }
        });

    }


    private void insertPdata() {


            if (TextUtils.isEmpty(nic.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(name.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(date.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(age.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(blood.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(diseases.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
            else if (TextUtils.isEmpty(connum.getText().toString()))
                Toast.makeText(getApplicationContext(), "Please Enter an Id", Toast.LENGTH_SHORT).show();
            else {


                //String m1 = male.getText().toString();
                //String m2 = female.getText().toString();

                //String gen;

                //if (male.isChecked()) {
                //    gen = m1;
               // } else {
               //     gen = m2;
               // }


                pdata.setNic(nic.getText().toString().trim());
                pdata.setName(name.getText().toString().trim());
                pdata.setGen(gender.getText().toString().trim());
                pdata.setDate(date.getText().toString().trim());
                pdata.setTime(time.getText().toString().trim());
                pdata.setAge(age.getText().toString().trim());
                pdata.setBlood(blood.getText().toString().trim());
                pdata.setDiseases(diseases.getText().toString().trim());
                pdata.setConnum(connum.getText().toString().trim());


                dbRef.push().setValue(pdata);

                Toast.makeText(getApplicationContext(), "Add Appontment SuccessFully", Toast.LENGTH_SHORT).show();
                clearControls();
            }


    } */






}