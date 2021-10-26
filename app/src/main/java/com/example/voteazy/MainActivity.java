package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnvoter;
    Button btnadmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnvoter = findViewById(R.id.voterbtn);
        btnadmin = findViewById(R.id.adminbtn);
        btnvoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent( getApplicationContext(), voterlogin.class);
              startActivity(intent);
            }
        });

       btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), adminlogin.class);
                startActivity(intent);
            }
        });

    }
}