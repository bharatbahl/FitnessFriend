package com.example.bharatbahl.fitnessfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class intake extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intake);
        t=(TextView)findViewById(R.id.textView8);
        String s=getIntent().getStringExtra("taken");
        t.setText("Calories Taken = "+s);
    }
}
