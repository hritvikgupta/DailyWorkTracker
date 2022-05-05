package com.example.dailyworktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrackingOptions extends AppCompatActivity {

    ListView lsview;
    ArrayList<String> options;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_options);

        lsview = findViewById(R.id.lsview);
        options = new ArrayList<String>();
        options.add("Add Meals");
        options.add("Add Workout");
        options.add("Add Foot Steps");
        options.add("Add Water Intake");
        options.add("Provide Feedback");

       // ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, options);
        CustomAdapter ad = new CustomAdapter(this, R.layout.my_custom_adapter, options);
        lsview.setAdapter(ad);

        lsview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TrackingOptions.this, "You Clicked on" + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();

            }
        });







    }
}