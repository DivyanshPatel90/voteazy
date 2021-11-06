package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminpage extends AppCompatActivity {
    Button startvotingbtn;
    Button resultbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

//        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.accent));

        startvotingbtn = findViewById(R.id.startvotingbtn);
        resultbtn  = findViewById(R.id.resultbtn);

        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),result_page.class);
                startActivity(intent);

            }
        });

        startvotingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),candidate_profile.class);
                startActivity(intent);

            }
        });
    }
}