package com.example.dailyworktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MealFragmentActivity extends AppCompatActivity{

    // MealFragmen that we have not used
    //https://stackoverflow.com/questions/36100187/how-to-start-fragment-from-an-activity
    //Probably above we will find answers
    ListView lsViewMeals;
    LayoutInflater inflater;
    ArrayList<String> meals;
    ArrayList<String> options;
    TextView inMealText, outMealText;

    Button mealButton;
    int a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_fragment);

        mealButton = findViewById(R.id.mealButton);
        lsViewMeals = findViewById(R.id.listViewMeals);

        options = new ArrayList<String>();
        options.add("BreakFast");
        options.add("Lunch");
        options.add("Dinner");


        //mealButton.setTag(1, "BreakFast");

        newOptionAdapter ad = new newOptionAdapter(MealFragmentActivity.this, R.layout.new_option_adapter, options);
        lsViewMeals.setAdapter(ad);




    }
}