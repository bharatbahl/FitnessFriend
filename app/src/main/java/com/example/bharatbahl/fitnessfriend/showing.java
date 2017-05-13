package com.example.bharatbahl.fitnessfriend;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class showing extends AppCompatActivity {
ListView lv;
    DBAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing);
        adapter=new DBAdapter(this);
        lv=(ListView)findViewById(R.id.listview);
        ArrayList<String> a=new ArrayList<>();
        Cursor c=adapter.showAllRecords();
while(c.moveToNext()) {
    a.add("Username : "+c.getString(0)+"\nSex : " + c.getString(2)+"\nEmail :  "+ c.getString(3));

}
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(arrayAdapter);
    }

}
