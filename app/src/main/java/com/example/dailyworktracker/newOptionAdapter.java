package com.example.dailyworktracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class newOptionAdapter extends ArrayAdapter<String> {

    ArrayList<String> arr;
    EditText inMealText;
    TextView outMealText;
    Button mealButton;
    Context context;



    public newOptionAdapter(@NonNull Context context, int resource, ArrayList<String> arr) {
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
        //convertView = LayoutInflater.from(getContext()).inflate(R.layout.new_option_adapter, parent,false);
        //TextView t = convertView.findViewById(R.id.mealOptionText);
        //t.setText(getItem(position));

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.new_option_adapter, null, true);
            convertView.setTag(holder);
        }
        else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }



        Button mealButton = convertView.findViewById(R.id.mealButton);
        inMealText = convertView.findViewById(R.id.inMealText);
        outMealText  = convertView.findViewById(R.id.outMealText);
        //mealButton.setTag(1, position);


        if(getItem(position).equals("BreakFast") ) {
            mealButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context, "Clicked" +getItem(position)+mealButton.getTag(), Toast.LENGTH_SHORT).show();
                    outMealText.setText(inMealText.getText().toString());

                }
            });
        }



        return convertView;
    }

    private class ViewHolder {
        protected Button mealButton;
        private TextView outMealText;
        private EditText inMealText;
    }
}
