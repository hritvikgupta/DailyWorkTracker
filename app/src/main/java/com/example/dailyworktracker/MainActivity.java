package com.example.dailyworktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eID, ePass;
    Button loginID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eID = findViewById(R.id.eID);
        ePass = findViewById(R.id.ePass);
        loginID = findViewById(R.id.loginID);
        String emailID = "12345";
        String passID = "12345";

        loginID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(eID.getText().toString().isEmpty() || ePass.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Provide Correct Credentials", Toast.LENGTH_SHORT).show();

                }
                if(eID.getText().toString().equals(emailID) && ePass.getText().toString().equals(passID))
                {
                    Intent intent = new Intent(MainActivity.this, com.example.dailyworktracker.TrackingOptions.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please Provide Correct Credentials", Toast.LENGTH_SHORT).show();

                }



            }
        });





    }
}