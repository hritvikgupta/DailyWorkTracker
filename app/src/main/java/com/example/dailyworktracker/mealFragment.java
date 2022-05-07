package com.example.dailyworktracker;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class mealFragment extends Fragment  {

    ListView lsViewMeals;
    LayoutInflater inflater;
    ArrayList<String> options;
    ItemSelected mealFragment;
    Button mealButton;


    interface ItemSelected{
        void OnItemSelected(int index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mealFragment = (ItemSelected) context;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mealButton = view.findViewById(R.id.mealButton);
        lsViewMeals = view.findViewById(R.id.lsViewMeals);


        options = new ArrayList<String>();
        options.add("BreakFast");
        options.add("Lunch");
        options.add("Dinner");
        options.add("Snacks");

        optionAdapter ad = new optionAdapter(getActivity(), R.layout.optionadapter, options);
        lsViewMeals.setAdapter(ad);

        lsViewMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mealFragment.OnItemSelected(i);
            }
        });



    }
}