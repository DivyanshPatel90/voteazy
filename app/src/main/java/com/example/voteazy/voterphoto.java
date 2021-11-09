package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class voterphoto extends AppCompatActivity {
    TextView thanktxt;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voterphoto);

        thanktxt = findViewById(R.id.thanku);
        lottie = findViewById(R.id.lottie);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.ticksound);
        mediaPlayer.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        },5000);


    }
}