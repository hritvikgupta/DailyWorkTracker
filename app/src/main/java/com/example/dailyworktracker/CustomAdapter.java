package com.example.dailyworktracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {

    private ArrayList<String> arr;
    private Context context;

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
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_custom_adapter_layout_2, parent, false);
        TextView t  =  convertView.findViewById(R.id.tView2);
        t.setText(getItem(position));
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
