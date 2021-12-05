package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestAppointmentInsert extends AppCompatActivity {

    EditText txt_hid, txt_prov,txt_name, txt_city, txt_addr, txt_desc, txt_conNo;
    Button btn_addHo;
    DatabaseReference dbRef;
    HospitalProvince hp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_appointment_insert);

        txt_hid = findViewById(R.id.et_hid);
        txt_prov = findViewById(R.id.et_prov);
        txt_name = findViewById(R.id.et_hName);
        txt_city = findViewById(R.id.et_city);
        txt_addr = findViewById(R.id.et_addr);
        txt_desc = findViewById(R.id.et_desc);
        txt_conNo = findViewById(R.id.et_conNo);

        hp = new HospitalProvince();

        final Button buttonAdd = findViewById(R.id.btn_addHo);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("HospitalProvince");

                hp.sethID(txt_hid.getText().toString().trim());
                hp.setProvince(txt_prov.getText().toString().trim());
                hp.sethName(txt_name.getText().toString().trim());
                hp.setCity(txt_city.getText().toString().trim());
                hp.setAddress(txt_addr.getText().toString().trim());
                hp.setDesc(txt_desc.getText().toString().trim());
                hp.setConNo(Integer.parseInt(txt_conNo.getText().toString().trim()));

                dbRef.push().setValue(hp);

                Toast.makeText(getApplicationContext(), "Data saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}