package com.example.dailyworktracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
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
import android.content.*;


public class TrackingOptions extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    ListView lsview;
    ArrayList<String> options;
    TextView dateText;
    Button dateButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_options);

        //These are from the adapter xml attributes
        dateText = findViewById(R.id.dateText);
        dateButton  = findViewById(R.id.dateButton);

        //These are from the this activity attributes
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
                if(adapterView.getItemAtPosition(i).equals("Add Meals"))
                {
                   Intent intent = new Intent(TrackingOptions.this, com.example.dailyworktracker.MealFragmentActivity.class);
                    startActivity(intent);



                }
            }
        });

        // Now what we have done is we have taken the date from the user using the DatePickerClass
        // here on select button will show case the class on to the view
        //it means onCreateDialog is show using below
        // Now when the class onCreateDialog has taken the date from the view or the user using below
        // then we need to set the date to what have been chosen for that we use the onDate set
        //onDateSet set the chosen date that has been passed into it.
        //after that the date is displayed using the dateText View that has been created
        //https://www.geeksforgeeks.org/datepickerdialog-in-android/ This is being used for creating the date dialog

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating an instance of class DatePicker that we have created
                //First statement is initialised it and second declared it
                // The third statement desplayed it using the fragment manager
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