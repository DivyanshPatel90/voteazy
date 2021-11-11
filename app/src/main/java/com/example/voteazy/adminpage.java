package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminpage extends AppCompatActivity {
    Button startvotingbtn;
    Button resultbtn;
    Context context;
    Resources resources;

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

        int i = (MainActivity.languageselected);
        if (MainActivity.languages[i].equals("English")) {

            context = LocaleHelper.setLocale(adminpage.this, "en");
            resources = context.getResources();
            startvotingbtn.setText(resources.getString(R.string.conduct_voting));
            resultbtn.setText(resources.getString(R.string.result));

        }

        if (MainActivity.languages[i].equals("हिंदी")) {
            context = LocaleHelper.setLocale(adminpage.this, "hi");
            resources = context.getResources();
           startvotingbtn.setText(resources.getString(R.string.conduct_voting));
           resultbtn.setText(resources.getString(R.string.result));
        }
        if (MainActivity.languages[i].equals("বাংলা")) {
            context = LocaleHelper.setLocale(adminpage.this, "bn");
            resources = context.getResources();
            startvotingbtn.setText(resources.getString(R.string.conduct_voting));
            resultbtn.setText(resources.getString(R.string.result));
        }

        if (MainActivity.languages[i].equals("मराठी")) {
            context = LocaleHelper.setLocale(adminpage.this, "mr");
            resources = context.getResources();
            startvotingbtn.setText(resources.getString(R.string.conduct_voting));
            resultbtn.setText(resources.getString(R.string.result));
        }
        if (MainActivity.languages[i].equals("తెలుగు")) {
            context = LocaleHelper.setLocale(adminpage.this, "te");
            resources = context.getResources();
            startvotingbtn.setText(resources.getString(R.string.conduct_voting));
            resultbtn.setText(resources.getString(R.string.result));
        }

        if (MainActivity.languages[i].equals("தமிழ்")) {
            context = LocaleHelper.setLocale(adminpage.this, "ta");
            resources = context.getResources();
            startvotingbtn.setText(resources.getString(R.string.conduct_voting));
            resultbtn.setText(resources.getString(R.string.result));
        }

        if (MainActivity.languages[i].equals("ગુજરાતી")) {
            context = LocaleHelper.setLocale(adminpage.this, "gu");
            resources = context.getResources();
            startvotingbtn.setText(resources.getString(R.string.conduct_voting));
            resultbtn.setText(resources.getString(R.string.result));
        }

//        // Change language
//        int i = (MainActivity.languageselected);
//        if (MainActivity.languages[i].equals("English")) {
//
//            context = LocaleHelper.setLocale(adminpage.this, "en");
//            resources = context.getResources();
//
//
//
//        }
//        if (MainActivity.languages[i].equals("हिंदी")) {
//            context = LocaleHelper.setLocale(adminpage.this, "hi");
//            resources = context.getResources();
//
//        }



    }
}