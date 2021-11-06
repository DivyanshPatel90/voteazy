package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class votersignup extends AppCompatActivity {
    Button btnvotersignup;
    TextView loginvoter;
    TextView signuptext;
    TextView alreadyusertext;
    EditText voterphone;
    EditText voterAadhar;
    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votersignup);

        btnvotersignup = findViewById(R.id.votersignupbtn);
        loginvoter  = findViewById(R.id.voterlogin);
        signuptext  = findViewById(R.id.Welcome);
        alreadyusertext = findViewById(R.id.text);
        voterphone = findViewById(R.id.voterPhone);
        voterAadhar = findViewById(R.id.voteraadhar);

        btnvotersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aadhar number check;
                String num = voterAadhar.getText().toString();
                boolean result = Verhoeff.validateVerhoeff(num);
                String  msg = String.valueOf(result);
                if(msg == "true"){
//                    Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Enter valid Aadhar number.",Toast.LENGTH_SHORT).show();
                }

            }
        });

        loginvoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(  getBaseContext() , voterlogin.class);
                startActivity(intent);
                finish();
            }
        });

        btnvotersignup.setTranslationY(300);
        loginvoter.setTranslationY(300);
        signuptext.setTranslationY(300);
        voterphone.setTranslationY(300);
        alreadyusertext.setTranslationY(300);
        voterAadhar.setTranslationY(300);


        btnvotersignup.setAlpha(v);
        loginvoter.setAlpha(v);
        signuptext.setAlpha(v);
        voterphone.setAlpha(v);
        alreadyusertext.setAlpha(v);
        voterAadhar.setAlpha(v);

        btnvotersignup.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        loginvoter.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signuptext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        alreadyusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterAadhar.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
    }
}