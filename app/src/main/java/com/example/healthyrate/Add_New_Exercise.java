package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_New_Exercise extends AppCompatActivity {


    EditText date,from,to,description;
    Button btneadd,btneshow;
    DatabaseReference dbRef;
    execise exerObj;


    //new
    
    /*
    private String uDate,uFrom,uTo,uDes;

     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_exercise);




        date = findViewById(R.id.txtdatee);
        from = findViewById(R.id.txtfromm);
        to = findViewById(R.id.editTextTime2);
        description = findViewById(R.id.txtsm);
        btneadd = findViewById(R.id.btnadde);
        btneshow= findViewById(R.id.button5);


        exerObj = new execise();




        //new
        /*
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            btneadd.setText("Update");
            uDate=bundle.getString("uDate");
            uFrom=bundle.getString("uFrom");
            uTo=bundle.getString("uTo");
            uDes=bundle.getString("uDes");


            date.setText(uDate);
            from.setText(uFrom);
            to.setText(uTo);
            description.setText(uDes);


        }else{
            btneadd.setText("Save");
        }

         */




        btneshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Add_New_Exercise.this,ShoweActivity.class));
            }
        });



    }




    private void clearControls() {
        date.setText("");
        from.setText("");
        to.setText("");
        description.setText("");

    }



    public void saveData(View view){
        dbRef = FirebaseDatabase.getInstance().getReference().child("eData");


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



            exerObj.setDate(date.getText().toString().trim());
            exerObj.setFrom(from.getText().toString().trim());
            exerObj.setTo(to.getText().toString().trim());
            exerObj.setDescription(description.getText().toString().trim());


            dbRef.push().setValue(exerObj);
            //dbRef.child("LabappointmentData").setValue(exerObj);

            Toast.makeText(getApplicationContext(), "Add New Exercise SuccessFully", Toast.LENGTH_SHORT).show();
            clearControls();





        }





    }









}