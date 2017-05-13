package com.example.bharatbahl.fitnessfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BMI extends AppCompatActivity {
EditText et1,et2,et3;
    double bmi,wt,ht,req,age;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        et1=(EditText)findViewById(R.id.editText9);
        et2=(EditText)findViewById(R.id.editText15);
        et3=(EditText)findViewById(R.id.editText16);
        b1=(Button)findViewById(R.id.button10);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wt=Double.parseDouble(et1.getText().toString());
                ht=Double.parseDouble(et2.getText().toString());
                age=Double.parseDouble(et3.getText().toString());
                bmi=wt/(ht*ht);
                req=66.67+(13.75*wt)+(5*ht)-6.67*age;
                Intent i=new Intent(getBaseContext(),dietplan.class);
                i.putExtra("bmi",bmi+"");
                i.putExtra("req",req+"");
                startActivity(i);
            }
        });
    }
}
