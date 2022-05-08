package com.example.dailyworktracker;

public class storeEditModel {

    //This class stores the multiple values from list view called by adapter ans pass it
    //to the mealfragment
    private String storeEditText;
    public String getEditTextValue(){
        return storeEditText;

    }
    public void setEditTextValue(String storeEditText){
        this.storeEditText = storeEditText;
    }
}
