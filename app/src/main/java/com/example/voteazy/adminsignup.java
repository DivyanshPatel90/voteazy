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

public class adminsignup extends AppCompatActivity {

    Button btnadminsignup;
    TextView adminlogin;
    EditText aadharadmin;
    EditText adminphone;
    TextView alreadyusertext;
    TextView signuptext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsignup);

        btnadminsignup = findViewById(R.id.adminsignupbtn);
        adminlogin = findViewById(R.id.adminlogin);
        aadharadmin = findViewById(R.id.adminaadhar);
        adminphone = findViewById(R.id.adminPhone);
        alreadyusertext = findViewById(R.id.text);
        signuptext = findViewById(R.id.Welcome);
        final ProgressBar progressBar = findViewById(R.id.progressbar);
        float v = 0;



        btnadminsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Aadhar number check;
                String num = aadharadmin.getText().toString();
                boolean result = Verhoeff.validateVerhoeff(num);
                String msg = String.valueOf(result);


                if (num.trim().isEmpty() ){
                    Toast.makeText(getBaseContext(),"Enter Aadhar Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(! msg.equals("true")){
                    Toast.makeText(getBaseContext(),"Enter Valid Aadhar Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(adminphone .getText().toString().trim().isEmpty()){
                    Toast.makeText(getBaseContext(),"Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }




                progressBar.setVisibility(View.VISIBLE);
                btnadminsignup.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + adminphone .getText().toString(),
                        60,
                        TimeUnit.SECONDS,adminsignup.this,

                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                               btnadminsignup.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                               btnadminsignup.setVisibility(View.VISIBLE);
                                Toast.makeText(adminsignup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                btnadminsignup.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getBaseContext(), adminotpverification.class);
                                intent.putExtra("mobile", adminphone.getText().toString());
                                intent.putExtra("varificationId", verificationId);
                                startActivity(intent);
                            }

                        }
                );

            }
        });





//        btnadminsignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //Aadhar number check;
//                String num = aadharadmin.getText().toString();
//                boolean result = Verhoeff.validateVerhoeff(num);
//                String msg = String.valueOf(result);
//
//
//                if (!num.trim().isEmpty() && !(adminphone.getText().toString().isEmpty())) {
//                    if (!msg.equals("true")) {
//                        Toast.makeText(getApplicationContext(), "Enter valid Aadhar number.", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Intent intent = new Intent(getBaseContext(), adminotpverification.class);
//                        startActivity(intent);
//                    }
//                }
//
//                else {
//                    if (!num.trim().isEmpty() && adminphone.getText().toString().isEmpty()) {
//                        Toast.makeText(getApplicationContext(), "Enter Phone number.", Toast.LENGTH_SHORT).show();
//
//                    } else if (num.trim().isEmpty() && !adminphone.getText().toString().isEmpty()) {
//                        Toast.makeText(getApplicationContext(), "Enter Aadhar number.", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Please Enter data", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//
//            }
//        });

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), adminlogin.class);
                startActivity(intent);
                finish();
            }
        });


        btnadminsignup.setTranslationY(300);
        adminlogin.setTranslationY(300);
        signuptext.setTranslationY(300);
        adminphone.setTranslationY(300);
        alreadyusertext.setTranslationY(300);
        aadharadmin.setTranslationY(300);


        btnadminsignup.setAlpha(v);
        adminlogin.setAlpha(v);
        signuptext.setAlpha(v);
        adminphone.setAlpha(v);
        alreadyusertext.setAlpha(v);
        aadharadmin.setAlpha(v);

        btnadminsignup.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminlogin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signuptext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        alreadyusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        aadharadmin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
    }
}