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

public class MealFragmentActivity extends AppCompatActivity {

    // MealFragmen that we have not used
    //https://stackoverflow.com/questions/36100187/how-to-start-fragment-from-an-activity
    //Probably above we will find answers
    ListView lsViewMeals;
    LayoutInflater inflater;
    ArrayList<String> meals;
    ArrayList<String> options;
    TextView inMealText, outMealText;
    com.example.dailyworktracker.mealFragment.ItemSelected mealFragment;
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
        options.add("Snacks");

        optionAdapter ad = new optionAdapter(this, R.layout.optionadapter, options);
        lsViewMeals.setAdapter(ad);

        lsViewMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                findViewById(R.id.mealButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MealFragmentActivity.this, "clicked" + i, Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }
}