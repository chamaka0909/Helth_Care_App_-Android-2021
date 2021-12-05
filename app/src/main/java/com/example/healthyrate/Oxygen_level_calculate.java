package com.example.healthyrate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Oxygen_level_calculate extends AppCompatActivity {

    EditText etoxygenlevel;
    TextView tvmessage;
    int oxygenlevel = 90;
    int oxylevelbetween = 94;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen_level_calculate);

        etoxygenlevel = (EditText)findViewById(R.id.etoxygenlevel);
        tvmessage = (TextView)findViewById(R.id.tvmessage);
    }

    public  void guessClicked(View v){

        int numberinput = Integer.parseInt(etoxygenlevel.getText().toString());

        if(numberinput < oxygenlevel ){

            tvmessage.setText("Need To Get Medical Attention");
            Toast.makeText(Oxygen_level_calculate.this,"Need To Get Medical Attention",Toast.LENGTH_SHORT).show();


        }else if (numberinput >= oxylevelbetween){

            tvmessage.setText("Normal Oxygen Level");
            Toast.makeText(Oxygen_level_calculate.this,"Normal Oxygen Level",Toast.LENGTH_SHORT).show();
        }
        else {
            tvmessage.setText("Attention to your health");
            Toast.makeText(Oxygen_level_calculate.this,"Attention to your health",Toast.LENGTH_SHORT).show();

        }
    }
}