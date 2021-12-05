package com.example.healthyrate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Covid_Test_Appointment extends AppCompatActivity {

    private static final String TAG = "Covid_Test_Appointment";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListner;



    //views
    EditText etname, etage, etphone, etaddress, etapoidate;
    Spinner selecttype;
    Button btnsub, btnshow;

    DatabaseReference patientDbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_test_appointment);

        mDisplayDate = (EditText) findViewById(R.id.etapoidate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Covid_Test_Appointment.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListner,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d(TAG, "onDateSet: mm/dd/yyy"  + month+ "/"+dayOfMonth+"/"+year);
                String date = month+ "/"+dayOfMonth+"/"+year;
                mDisplayDate.setText(date);

            }
        };

        etname = findViewById(R.id.etname);
        etage = findViewById(R.id.etage);
        etphone = findViewById(R.id.etphone);
        etaddress = findViewById(R.id.etaddress);
        etapoidate = findViewById(R.id.etapoidate);
        selecttype = findViewById(R.id.selecttype);
        btnsub = findViewById(R.id.btnsub);
        btnshow = findViewById(R.id.btnshow);




        etphone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (validatemobile(etphone.getText().toString())) {

                    btnsub.setEnabled(true);
                } else
                    btnsub.setEnabled(false);
                etphone.setError("Invalid Mobile Number");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        patientDbref = FirebaseDatabase.getInstance().getReference().child("Covid_test_appointment");

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                insertpatientdata();
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Covid_Test_Appointment.this, ShowActivity.class));
                finish();
            }
        });



    }
    private void clearControls(){

        etname.setText("");
        etage.setText("");
        etphone.setText("");
        etaddress.setText("");
        etapoidate.setText("");

    }

    private  void insertpatientdata(){
        String name = etname.getText().toString();
        String age = etage.getText().toString();
        String phone = etphone.getText().toString();
        String address = etaddress.getText().toString();
        String date = etapoidate.getText().toString();
        String type = selecttype.getSelectedItem().toString();

        patients patients = new patients(name,age,phone,address,date,type);;
        patientDbref.push().setValue(patients);
        Toast.makeText(Covid_Test_Appointment.this,"Data successfully inserted!",Toast.LENGTH_SHORT).show();
        clearControls();
    }

    boolean validatemobile (String input){

        Pattern p = Pattern.compile("[0-9]{10}");
        Matcher m = p.matcher(input);
        return m.matches();
    }




}