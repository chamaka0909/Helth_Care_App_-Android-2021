package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Get_lab_report extends AppCompatActivity {

    EditText nic;
    EditText name;
    EditText date;
    EditText time;
    EditText age;
    EditText blood;
    EditText diseases;
    EditText connum;
    Button addAp;
    RadioButton male,female;


    DatabaseReference appLdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_lab_report);


        nic = findViewById(R.id.txtnic);
        name = findViewById(R.id.txtname);
        date = findViewById(R.id.txtdatell);
        time = findViewById(R.id.txttimel);
        age = findViewById(R.id.txtagel);
        blood = findViewById(R.id.txtblood);
        diseases = findViewById(R.id.txtsuf);
        connum = findViewById(R.id.txtcon);
        addAp = findViewById(R.id.btnaddap);
        male = findViewById(R.id.radb1);
        female = findViewById(R.id.radb2);


        appLdata = FirebaseDatabase.getInstance().getReference().child("pData");
        addAp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertPdata();
            }
        });
    }

    private void insertPdata(){
        String nnic = nic.getText().toString();
        String nname =name.getText().toString();
        String ddate =date.getText().toString();
        String ttime =time.getText().toString();
        String aage =age.getText().toString();
        String bblod =blood.getText().toString();
        String ddiseases =diseases.getText().toString();
        String cconnum =connum.getText().toString();

        String m1 = male.getText().toString();
        String m2 = female.getText().toString();

        String gen;

        if(male.isChecked()){
            gen = m1;
        }else{
            gen = m2;
        }



        pData pdata = new pData(nnic,nname,gen,ddate,ttime,aage,bblod,ddiseases,cconnum);
        appLdata.push().setValue(pdata);

        Toast.makeText(Get_lab_report.this,"Data Inserted",Toast.LENGTH_SHORT).show();
    }
}