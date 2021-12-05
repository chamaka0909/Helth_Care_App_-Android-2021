package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
=======
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
>>>>>>> origin/master

import java.text.DecimalFormat;

public class CalculateFitness extends AppCompatActivity {


    EditText age,height,weight,gweight;
    Button cal;
    String hrate;
    Double iweight;
    Double bmi;
    Double bmr;
    String thrate;
    Double fatp;
    String status;


<<<<<<< HEAD
=======
    //round to two decimal format
>>>>>>> origin/master
    private static DecimalFormat df = new DecimalFormat("0.00");







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_fitness);

        age = findViewById(R.id.txtagefit);
        height=findViewById(R.id.txthfitt);
        weight=findViewById(R.id.txtwfitt);
        gweight=findViewById(R.id.txtgoalfitt);
        cal=findViewById(R.id.btncheckrr);




<<<<<<< HEAD
=======

>>>>>>> origin/master
/*



        if (agee>20) {
            thrate="100-170";
        } else if(agee >30){
            thrate="95-162";
        }
        else if(agee >35){
            thrate="93-153";
        }
        else if(agee >40){
            thrate="88-149";
        }
        else if(agee>50){
            thrate="88-145";
        }
        else if(agee>60){
            thrate="83-140";
        }
        else if(agee>70){
            thrate="80-136";
        }
        else
            thrate="78-132";






        Double weightt= Double.parseDouble(weight.getText().toString());
        Double heightt= Double.parseDouble(height.getText().toString());

        iweight = weightt + (heightt * 2.3);



        bmi = (weightt/heightt)*heightt;



        bmr = 88.36 +(13.397*weightt)+(4.799*heightt);


        fatp = (1.20*bmi)+(0.23 * agee)-16.2;





 */












        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();

            }
        });




    }

    public void sendData() {


<<<<<<< HEAD


        if (TextUtils.isEmpty(age.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Age", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(height.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Height", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(weight.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Weight", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(gweight.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please Enter an Goal Weight", Toast.LENGTH_SHORT).show();
        }else {


            // String Hrate,THrate,Iweight,Bmi,Bmr,Bfat;

            int agee = Integer.parseInt(age.getText().toString());

            if (agee < 20) {
                hrate = "200";
            } else if (agee < 30) {
                hrate = "190";
            } else if (agee < 35) {
                hrate = "185";
            } else if (agee < 40) {
                hrate = "180";
            } else if (agee < 50) {
                hrate = "170";
            } else if (agee < 60) {
                hrate = "160";
            } else if (agee < 70) {
                hrate = "150";
            } else
                hrate = "205";


            if (agee < 20) {
                thrate = "100-170";
            } else if (agee < 30) {
                thrate = "95-162";
            } else if (agee < 35) {
                thrate = "93-153";
            } else if (agee < 40) {
                thrate = "88-149";
            } else if (agee < 50) {
                thrate = "88-145";
            } else if (agee < 60) {
                thrate = "83-140";
            } else if (agee < 70) {
                thrate = "80-136";
            } else
                thrate = "78-132";


            Double weightt = Double.parseDouble(weight.getText().toString());
            Double heightt = Double.parseDouble(height.getText().toString());

            iweight = (weightt) + ((heightt) * (2.3));

            String iiiiweight = df.format(iweight);

            //String iiiiweight = iweight.toString();


            bmi = (weightt) / (heightt * heightt);
            String bbbmi = df.format(bmi);


            //String bbbmi = bmi.toString();


            if (bmi < 18.5) {
                status = "You are Underweight. Get More Protein";
            } else if (bmi < 24.9) {
                status = "You are Healthy. Awesome";
            } else if (bmi < 29.9) {
                status = "You are Owerweight. Please Control Your Diet";
            } else {
                status = "You are Obese. Please Do Exercise";
            }


            bmr = 88.36 + (13.397 * weightt) + (4.799 * heightt);

            String bbbmr = df.format(bmr);

            // String bbbmr = bbb.toString();


            fatp = (1.20 * bmi) + (0.23 * agee) - 16.2;

            String fffatp = df.format(fatp);


            //String fffatp = fff.toString();


            Intent i = new Intent(CalculateFitness.this, ResultFitness.class);

            i.putExtra("Hrate", hrate);
            i.putExtra("THrate", thrate);
            i.putExtra("Iweight", iiiiweight);
            i.putExtra("Bmi", bbbmi);
            i.putExtra("Bmr", bbbmr);
            i.putExtra("Bfat", fffatp);
            i.putExtra("sstatus", status);
            startActivity(i);


        }
=======
        //String Hrate,THrate,Iweight,Bmi,Bmr,Bfat;

        int agee= Integer.parseInt(age.getText().toString());

        if (agee < 20) {
            hrate="200";
        } else if(agee <30){
            hrate="190";
        }
        else if(agee <35){
            hrate="185";
        }
        else if(agee <40){
            hrate="180";
        }
        else if(agee <50){
            hrate="170";
        }
        else if(agee<60){
            hrate="160";
        }
        else if(agee<70){
            hrate="150";
        }
        else
            hrate="205";




        if (agee<20) {
            thrate="100-170";
        } else if(agee <30){
            thrate="95-162";
        }
        else if(agee <35){
            thrate="93-153";
        }
        else if(agee <40){
            thrate="88-149";
        }
        else if(agee<50){
            thrate="88-145";
        }
        else if(agee<60){
            thrate="83-140";
        }
        else if(agee<70){
            thrate="80-136";
        }
        else
            thrate="78-132";




         Double weightt= Double.parseDouble(weight.getText().toString());
        Double heightt= Double.parseDouble(height.getText().toString());

        iweight = (weightt) + ((heightt) * (2.3));

        String iiiiweight=df.format(iweight);

        //String iiiiweight = iweight.toString();



        bmi = (weightt)/(heightt*heightt);
        String bbbmi=df.format(bmi);


        //String bbbmi = bmi.toString();


        if(bmi < 18.5){
            status ="You are Underweight. Get More Protein";
        }else if(bmi < 24.9){
            status="You are Healthy. Awesome";
        }else if(bmi < 29.9){
            status="You are Owerweight. Please Control Your Diet";
        }else{
            status="You are Obese. Please Do Exercise";
        }



        bmr = 88.36 +(13.397*weightt)+(4.799*heightt);

        String bbbmr=df.format(bmr);

       // String bbbmr = bbb.toString();



        fatp = (1.20*bmi)+(0.23 * agee)-16.2;

        String fffatp=df.format(fatp);


       //String fffatp = fff.toString();






        Intent i = new Intent(CalculateFitness.this,ResultFitness.class);

        i.putExtra("Hrate",hrate);
        i.putExtra("THrate",thrate);
        i.putExtra("Iweight",iiiiweight);
        i.putExtra("Bmi",bbbmi);
        i.putExtra("Bmr",bbbmr);
        i.putExtra("Bfat",fffatp);
        i.putExtra("sstatus",status);
        startActivity(i);


>>>>>>> origin/master
    }
}