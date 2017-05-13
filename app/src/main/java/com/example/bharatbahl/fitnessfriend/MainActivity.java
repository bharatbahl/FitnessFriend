package com.example.bharatbahl.fitnessfriend;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1;
    Button b;
    DBAdapter adapter;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button2);
        b=(Button)findViewById(R.id.button);
        adapter=new DBAdapter(this);
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag=adapter.validate(username.getText().toString(),password.getText().toString());
                if(flag==true)
                {
                    Toast.makeText(getBaseContext(),"Valid USER",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getBaseContext(),HomeActivity.class);
                    i.putExtra("uname",username.getText().toString());
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"invalid USER",Toast.LENGTH_LONG).show();

                }
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),RegisterActivity.class);
                startActivity(i);
            }
        });
    }
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to Exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();


    }

}
