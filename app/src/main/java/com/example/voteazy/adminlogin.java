package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    Button btnadminlogin;
    TextView  signupadmin;
    TextView signuptext;
    TextView newusertext;
    EditText voterphone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        btnadminlogin = findViewById(R.id.adminloginbtn);
        signupadmin = findViewById(R.id.adminsignup);
        signuptext = findViewById(R.id.Welcome);
        voterphone = findViewById(R.id.adminPhone);
        newusertext = findViewById(R.id.text);
        final ProgressBar progressBar = findViewById(R.id.progressbar);

        float v = 0;

        btnadminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(voterphone.getText().toString().trim().isEmpty()){
                    Toast.makeText(getBaseContext(),"Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btnadminlogin.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(  getBaseContext() , adminpage.class);
                startActivity(intent);

            }
        });

        signupadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(  getBaseContext() , adminsignup.class);
                startActivity(intent);
                finish();
            }
        });

        btnadminlogin.setTranslationY(300);
        signupadmin.setTranslationY(300);
        signuptext.setTranslationY(300);
        voterphone.setTranslationY(300);
        newusertext.setTranslationY(300);


        btnadminlogin.setAlpha(v);
        signupadmin.setAlpha(v);
        signuptext.setAlpha(v);
        voterphone.setAlpha(v);
        newusertext.setAlpha(v);

        btnadminlogin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signupadmin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signuptext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        newusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();

    }
}