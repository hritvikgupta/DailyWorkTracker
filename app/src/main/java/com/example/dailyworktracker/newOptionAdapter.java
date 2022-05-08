package com.example.dailyworktracker;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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


    //Solution is in the https://demonuts.com/android-listview-tutorial/
    ArrayList<String> arr;
    EditText inMealText;
    TextView outMealText;
    Button mealButton;
    Context context;
    public static ArrayList<storeEditModel> storeEditModelArrayList;




    public newOptionAdapter(@NonNull Context context, int resource, ArrayList<String> arr, ArrayList<storeEditModel> storeEditModelArrayList) {
        super(context, resource, arr);
        this.context = context;
        this.arr = arr;
        this.storeEditModelArrayList = storeEditModelArrayList;

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
            holder.inMealText = (EditText) convertView.findViewById(R.id.inMealText);
            holder.mealOptionText = (TextView) convertView.findViewById(R.id.mealOptionText);
            holder.mealButton = (Button) convertView.findViewById(R.id.mealButton);
            convertView.setTag(holder);
        }
        else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.mealOptionText.setText(getItem(position));
        holder.inMealText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    storeEditModelArrayList.get(position).setEditTextValue(holder.inMealText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Toast.makeText(context, "Value Recived " + holder.inMealText.getText().toString().trim(),Toast.LENGTH_SHORT).show();


            }
        });








        return convertView;
    }

    private class ViewHolder {

        private EditText inMealText;
        private TextView mealOptionText;
        private Button mealButton;

    }

}
