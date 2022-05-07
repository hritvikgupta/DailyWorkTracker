package com.example.dailyworktracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class optionAdapter extends ArrayAdapter<String> {

    ArrayList<String> arr;
    private Context context;
    TextView inMealText, outMealText;
    String meals;




    public optionAdapter(@NonNull Context context, int resource, ArrayList<String> arr) {
        super(context, resource,arr);
        this.context = context;
        this.arr = arr;


    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.optionadapter, parent,false);
        //TextView t = convertView.findViewById(R.id.mealOptionText);
        //t.setText(getItem(position));

        Button mealButton = convertView.findViewById(R.id.mealButton);
        inMealText = convertView.findViewById(R.id.inMealText);
        outMealText  = convertView.findViewById(R.id.outMealText);
        //mealButton.setTag(position,"breakfast");
        if(position == 0) {
            mealButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context, "Clicked" +getItem(position), Toast.LENGTH_SHORT).show();
                    outMealText.setText(inMealText.getText().toString());

                }
            });
        }

        return convertView;
    }
}
