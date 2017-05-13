package com.example.bharatbahl.fitnessfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalorieBurner extends AppCompatActivity {
    EditText et6,et7,et8,et10,et11,et12,et13,et14;
    Button b;
    String total="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_burner);
        et6=(EditText)findViewById(R.id.editText6);
        et7=(EditText)findViewById(R.id.editText7);
        et8=(EditText)findViewById(R.id.editText8);
        et10=(EditText)findViewById(R.id.editText10);
        et11=(EditText)findViewById(R.id.editText11);
        et12=(EditText)findViewById(R.id.editText12);
        et13=(EditText)findViewById(R.id.editText13);
        et14=(EditText)findViewById(R.id.editText14);
        b=(Button)findViewById(R.id.button9);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double cal1=160*Double.parseDouble(et6.getText().toString());
                double cal2=400*Double.parseDouble(et7.getText().toString());
                double cal3=560*Double.parseDouble(et8.getText().toString());
                double cal4=730*Double.parseDouble(et10.getText().toString());
                double cal5=600*Double.parseDouble(et11.getText().toString());
                double cal6=400*Double.parseDouble(et12.getText().toString());
                double cal7=640*Double.parseDouble(et13.getText().toString());
                double cal8=800*Double.parseDouble(et14.getText().toString());
                double cal=cal1+cal2+cal3+cal4+cal5+cal6+cal7+cal8;
                total=cal+"";
                Intent i=new Intent(getBaseContext(),burnt.class);
                i.putExtra("burnt",total);
                startActivity(i);
                Toast.makeText(getBaseContext(),total+" CALORIES BURNT TODAY",Toast.LENGTH_LONG).show();
            }
        });

    }
}
