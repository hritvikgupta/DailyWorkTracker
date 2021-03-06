package com.example.dailyworktracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    TextView inMealText;
    ListView outMealText;
    public ArrayList<storeEditModel> storeEditModelArrayList;

    Button mealButton;
    int a = 1;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_fragment);

        mealButton = findViewById(R.id.mealButton);
        lsViewMeals = findViewById(R.id.listViewMeals);
        outMealText = findViewById(R.id.outMealText);
        ArrayList<String> ans = new ArrayList<String>();
        //CharSequence [] ans = new CharSequence[4];

        options = new ArrayList<String>();
        options.add("BreakFast");
        options.add("Lunch");
        options.add("Dinner");
        options.add("snacks");




        //mealButton.setTag(1, "BreakFast");
        storeEditModelArrayList = populateList();
        newOptionAdapter ad = new newOptionAdapter(MealFragmentActivity.this, R.layout.new_option_adapter, options, storeEditModelArrayList);
        lsViewMeals.setAdapter(ad);

        mealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MealFragmentActivity.this, "Meals"+newOptionAdapter.storeEditModelArrayList.get(1).getEditTextValue(),Toast.LENGTH_SHORT).show();
                for(i =0; i<newOptionAdapter.storeEditModelArrayList.size();i++) {
                    //Toast.makeText(MealFragmentActivity.this, "Meals"+newOptionAdapter.storeEditModelArrayList.get(i).getEditTextValue(),Toast.LENGTH_SHORT).show();
                    ans.add(options.get(i) + " : " +  newOptionAdapter.storeEditModelArrayList.get(i).getEditTextValue());

                }
               // Toast.makeText(MealFragmentActivity.this, "Meals"+ outMealText.getText(),Toast.LENGTH_SHORT).show();

                ArrayAdapter se = new ArrayAdapter(MealFragmentActivity.this, android.R.layout.simple_list_item_1,ans);
                outMealText.setAdapter(se);



            }
        });


    }
    private ArrayList<storeEditModel> populateList(){
        ArrayList<storeEditModel> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            storeEditModel editModel = new storeEditModel();
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }
        return list;
    }
}