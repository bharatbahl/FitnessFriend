package com.example.bharatbahl.fitnessfriend;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class count extends AppCompatActivity implements SensorEventListener {
SensorManager manager;
    Sensor stepCount;
    TextView tv;
    ListView lv;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        manager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        stepCount=manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        tv= (TextView) findViewById(R.id.textView9);
       // b=(Button)findViewById(R.id.button10);
        setTitle("Step Counter");
        tv.setText("");

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float steps[] = event.values;
        int myStep = (int) steps[0];
        Sensor mySensor = event.sensor;
        int mySensorType = mySensor.getType();
        if (mySensorType == Sensor.TYPE_STEP_COUNTER) {
            tv.setText("Steps = " + myStep);
        } else {
            tv.setText("No step sensor");
        }
        if (myStep >= 0) {
            tv.setText("Steps = " + myStep);
        } else {
            tv.setText("No step sensor");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onResume() {
        manager.registerListener(this,stepCount,SensorManager.SENSOR_DELAY_FASTEST);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this,stepCount);
    }
}
