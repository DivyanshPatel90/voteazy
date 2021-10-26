package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class voterlogin extends AppCompatActivity {

    Button btnvoterlogin;
    TextView signupvoter;
    TextView logintext;
    TextView sendotptxt;
    TextView newusertext;
    EditText voterphone;
    EditText voterOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voterlogin);

        btnvoterlogin = findViewById(R.id.voterloginbtn);
        signupvoter = findViewById(R.id.votersignup);
        logintext = findViewById(R.id.Welcome);
        sendotptxt = findViewById(R.id.resendotp);
        voterphone = findViewById(R.id.voterPhone);
        voterOTP = findViewById(R.id.otp);
        newusertext = findViewById(R.id.text);

        float v = 0;


       btnvoterlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), voting_page.class);
                startActivity(intent);
            }
        });


        signupvoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), votersignup.class);
                startActivity(intent);
                finish();
            }
        });

//      Animation
        btnvoterlogin.setTranslationY(300);
        signupvoter.setTranslationY(300);
        logintext.setTranslationY(300);
        sendotptxt.setTranslationY(300);
        voterphone.setTranslationY(300);
        voterOTP.setTranslationY(300);
        newusertext.setTranslationY(300);


        btnvoterlogin.setAlpha(v);
        signupvoter.setAlpha(v);
        logintext.setAlpha(v);
        sendotptxt.setAlpha(v);
        voterphone.setAlpha(v);
        voterOTP.setAlpha(v);
        newusertext.setAlpha(v);

        btnvoterlogin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signupvoter.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        logintext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        sendotptxt.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterOTP.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        newusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();



    }
}