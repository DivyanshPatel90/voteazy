package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.system.StructTimeval;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class adminpage extends AppCompatActivity {
    Button startvotingbtn;
    Button resultbtn;
    Context context;
    Resources resources;
    TextView timertext;
    TextView electionstarttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(), R.color.primary_text));

        startvotingbtn = findViewById(R.id.startvotingbtn);
        resultbtn  = findViewById(R.id.resultbtn);
        timertext = findViewById(R.id.timertxt);
        electionstarttext = findViewById(R.id.electionstarttxt);


        if(candidate_profile.votingstarted!=0){
            timertext.setVisibility(View.VISIBLE);
            electionstarttext.setVisibility(View.VISIBLE);
            startTimer();
        }





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

                if(candidate_profile.votingstarted==0){
                    Intent intent = new Intent(getBaseContext(),candidate_profile.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getBaseContext(),"Election already Started !",Toast.LENGTH_SHORT).show();
                }


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

    void startTimer(){
        long duration  = TimeUnit.DAYS.toMillis(1);
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millis) {
                String sDuration =
                        String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

                timertext.setText(sDuration);


            }

            @Override
            public void onFinish() {
                timertext.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
}