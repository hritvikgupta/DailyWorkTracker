package com.example.dailyworktracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {

    private ArrayList<String> arr;
    private Context context;
    ImageView draw_logo;
    private int[] logos = {
            R.drawable.meal3, R.drawable.workout, R.drawable.foot3, R.drawable.water, R.drawable.feedback
    };

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<String> arr) {
        super(context, resource, arr);
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
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_custom_adapter, parent, false);
        TextView t  =  convertView.findViewById(R.id.tView);
        t.setText(getItem(position));
        draw_logo = (ImageView) convertView.findViewById(R.id.imView);
        draw_logo.setImageResource(logos[position]);
        /*
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show();
            }
        });

         */


        return convertView;
    }
}
