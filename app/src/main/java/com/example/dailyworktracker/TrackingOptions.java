package com.example.dailyworktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TrackingOptions extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ListView lsview;
    ArrayList<String> options;
    TextView dateText;
    Button dateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_options);

        dateText = findViewById(R.id.dateText);
        dateButton  = findViewById(R.id.dateButton);


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

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.dailyworktracker.DatePicker mdatepicker;
                mdatepicker = new com.example.dailyworktracker.DatePicker();
                mdatepicker.show(getSupportFragmentManager(), "Select Date");


            }
        });


    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {
        Calendar mcalender = Calendar.getInstance();
        mcalender.set(Calendar.YEAR, i);
        mcalender.set(Calendar.MONTH, i1);
        mcalender.set(Calendar.DAY_OF_MONTH, i2);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mcalender.getTime());
        dateText.setText(selectedDate);

    }
}