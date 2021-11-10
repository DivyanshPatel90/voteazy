package com.example.voteazy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.security.AuthProvider;
import java.util.concurrent.TimeUnit;

public class voterlogin extends AppCompatActivity {

    Button btnvoterlogin;
    TextView signupvoter;
    TextView logintext;
    TextView newusertext;
    EditText voterphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voterlogin);

        btnvoterlogin = findViewById(R.id.voterloginbtn);
        signupvoter = findViewById(R.id.votersignup);
        logintext = findViewById(R.id.Welcome);
        voterphone = findViewById(R.id.voterPhone);
        newusertext = findViewById(R.id.text);
        final ProgressBar progressBar = findViewById(R.id.progressbar);
        float v = 0;

//       btnvoterlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                if (voterphone.getText().toString().trim().isEmpty()) {
//                    Toast.makeText(getBaseContext(), "Enter mobile number", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                progressBar.setVisibility(View.VISIBLE);
//                btnvoterlogin.setVisibility(View.INVISIBLE);
//
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        "+91" + voterphone.getText().toString(),
//                        60,
//                        TimeUnit.SECONDS,
//                        voterlogin.this,
//
//                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                            @Override
//                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                                progressBar.setVisibility(View.GONE);
//                                btnvoterlogin.setVisibility(View.VISIBLE);
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NonNull FirebaseException e) {
//                                progressBar.setVisibility(View.GONE);
//                                btnvoterlogin.setVisibility(View.VISIBLE);
//                                Toast.makeText(voterlogin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                                progressBar.setVisibility(View.GONE);
//                                btnvoterlogin.setVisibility(View.VISIBLE);
//                                Intent intent = new Intent(getBaseContext(), voterotpverification.class);
//                                intent.putExtra("mobile", voterphone.getText().toString());
//                                intent.putExtra("varificationId", verificationId);
//                                startActivity(intent);
//                            }
//
//
//                        }
//                );
//
//
//            }
//        });


       btnvoterlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getBaseContext(),voting_page.class));
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
        voterphone.setTranslationY(300);
        newusertext.setTranslationY(300);


        btnvoterlogin.setAlpha(v);
        signupvoter.setAlpha(v);
        logintext.setAlpha(v);
        voterphone.setAlpha(v);
        newusertext.setAlpha(v);

        btnvoterlogin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signupvoter.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        logintext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        newusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();


    }
}
