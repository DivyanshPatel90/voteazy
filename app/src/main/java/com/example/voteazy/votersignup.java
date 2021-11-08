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
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

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
        loginvoter = findViewById(R.id.voterlogin);
        signuptext = findViewById(R.id.Welcome);
        alreadyusertext = findViewById(R.id.text);
        voterphone = findViewById(R.id.voterPhone);
        voterAadhar = findViewById(R.id.voteraadhar);
        final ProgressBar progressBar = findViewById(R.id.progressbar);

        btnvotersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Aadhar number check;
                String num = voterAadhar.getText().toString();
                boolean result = Verhoeff.validateVerhoeff(num);
                String msg = String.valueOf(result);


                if (num.trim().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Enter Aadhar Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!msg.equals("true")) {
                    Toast.makeText(getBaseContext(), "Enter Valid Aadhar Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (voterphone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);
                btnvotersignup.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + voterphone.getText().toString(),
                        60,
                        TimeUnit.SECONDS, votersignup.this,

                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                btnvotersignup.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                btnvotersignup.setVisibility(View.VISIBLE);
                                Toast.makeText(votersignup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                btnvotersignup.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getBaseContext(), voterotpverification.class);
                                intent.putExtra("mobile", voterphone.getText().toString());
                                intent.putExtra("varificationId", verificationId);
                                startActivity(intent);
                            }

                        }
                );
            }
        });

        loginvoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), voterlogin.class);
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