package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class voterphoto extends AppCompatActivity {

    LottieAnimationView lottie;
    LottieAnimationView thanklottie;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voterphoto);


        lottie = findViewById(R.id.lottie);
        thanklottie = findViewById(R.id.lottiethank);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.ticksound);
        mediaPlayer.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                thanklottie.playAnimation();
            }
        },4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              startActivity(new Intent(getBaseContext(),MainActivity.class));
              finish();
            }
        },5000);



                // Change language
        int i = (MainActivity.languageselected);
        if (MainActivity.languages[i].equals("English")) {

            context = LocaleHelper.setLocale(voterphoto.this, "en");
            resources = context.getResources();



        }
        if (MainActivity.languages[i].equals("हिंदी")) {
            context = LocaleHelper.setLocale(voterphoto.this, "hi");
            resources = context.getResources();


        }
        if (MainActivity.languages[i].equals("বাংলা")) {
            context = LocaleHelper.setLocale(voterphoto.this, "bn");
            resources = context.getResources();

        }
        if (MainActivity.languages[i].equals("मराठी")) {
            context = LocaleHelper.setLocale(voterphoto.this, "mr");
            resources = context.getResources();

        }
        if (MainActivity.languages[i].equals("తెలుగు")) {
            context = LocaleHelper.setLocale(voterphoto.this, "te");
            resources = context.getResources();

        }
        if (MainActivity.languages[i].equals("தமிழ்")) {
            context = LocaleHelper.setLocale(voterphoto.this, "ta");
            resources = context.getResources();

        }

        if (MainActivity.languages[i].equals("ગુજરાતી")) {
            context = LocaleHelper.setLocale(voterphoto.this, "gu");
            resources = context.getResources();
        }
        }

}