package com.example.android.sensesensors;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the reference to the sensor manager
        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);

        // Get the list of sensor
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

       // List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_PRESSURE);

        List<Map<String, String>> sensorData = new ArrayList<Map<String,String>>();


        for (Sensor sensor: sensorList) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("name", sensor.getName());
            data.put("vendor", sensor.getVendor());
           // Toast toast = Toast.makeText(getApplicationContext(), sensor.getName(), Toast.LENGTH_SHORT);
            //toast.show();
            sensorData.add(data);
        }


        SimpleAdapter sa = new SimpleAdapter(this, sensorData, android.R.layout.simple_list_item_2, new String[]{"name", "vendor"}, new int[]{android.R.id.text1, android.R.id.text2});

        ListView lv = (ListView) findViewById(R.id.sensorList);
        lv.setAdapter(sa);

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos,
                                    long id) {

                Intent i = new Intent(MainActivity.this, PressActivity.class);
                startActivity(i);

            }
        });*/
    }
}
