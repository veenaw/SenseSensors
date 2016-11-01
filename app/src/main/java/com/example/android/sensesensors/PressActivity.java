package com.example.android.sensesensors;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PressActivity extends Activity implements SensorEventListener {

    private TextView pressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press);
        pressView = (TextView) findViewById(R.id.pressTxt);

        // Look for pressure sensor
        SensorManager snsMgr = (SensorManager) getSystemService(Service.SENSOR_SERVICE);

        Sensor pS = snsMgr.getDefaultSensor(Sensor.TYPE_PRESSURE);

        snsMgr.registerListener(this, pS, SensorManager.SENSOR_DELAY_UI);
    }



    @Override
    protected void onResume() {

        super.onResume();
        SensorManager snsMgr = (SensorManager) getSystemService(Service.SENSOR_SERVICE);

        Sensor pS = snsMgr.getDefaultSensor(Sensor.TYPE_PRESSURE);

        snsMgr.registerListener(this, pS, SensorManager.SENSOR_DELAY_UI);
    }



    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        pressView.setText("" + values[0]);

    }
}
