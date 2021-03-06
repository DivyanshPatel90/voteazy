package com.example.voteazy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class adminlogin extends AppCompatActivity {

    Button btnadminlogin;
    TextView  signupadmin;
    TextView signuptext;
    TextView newusertext;
    EditText adminphone;
    Context context;
    Resources resources;
    TextInputLayout textInputLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        btnadminlogin = findViewById(R.id.adminloginbtn);
        signupadmin = findViewById(R.id.adminsignup);
        signuptext = findViewById(R.id.Welcome);
        adminphone = findViewById(R.id.adminPhone);
        newusertext = findViewById(R.id.text);
        textInputLayout = findViewById(R.id.inputtextlayout);

        final ProgressBar progressBar = findViewById(R.id.progressbar);
        float v = 0;


        btnadminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(adminphone .getText().toString().trim().isEmpty()){
                    Toast.makeText(getBaseContext(),"Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btnadminlogin.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + adminphone .getText().toString(),
                        60,
                        TimeUnit.SECONDS,adminlogin.this,

                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                btnadminlogin.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                btnadminlogin.setVisibility(View.VISIBLE);
                                Toast.makeText(adminlogin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                btnadminlogin.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getBaseContext(), adminotpverification.class);
                                intent.putExtra("mobile", adminphone.getText().toString());
                                intent.putExtra("varificationId", verificationId);
                                startActivity(intent);
                            }


                        }
                );




            }
        });


//        btnadminlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getBaseContext(),adminpage.class));
//            }
//        });


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
        adminphone .setTranslationY(300);
        newusertext.setTranslationY(300);
        textInputLayout.setTranslationY(300);


        btnadminlogin.setAlpha(v);
        signupadmin.setAlpha(v);
        signuptext.setAlpha(v);
        adminphone .setAlpha(v);
        newusertext.setAlpha(v);
        textInputLayout.setAlpha(v);


        btnadminlogin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signupadmin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signuptext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminphone .animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        newusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        textInputLayout.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();




















































































































































































































































































                // Change language
        int i = (MainActivity.languageselected);
        if (MainActivity.languages[i].equals("English")) {

            context = LocaleHelper.setLocale(adminlogin.this, "en");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.l_o_g_i_n));
            adminphone.setHint(resources.getString(R.string.phone_number));
            btnadminlogin.setText(resources.getString(R.string.get_otp));
            newusertext.setText(resources.getString(R.string.new_user));
            signupadmin.setText(resources.getString(R.string.sign_up));


        }
        if (MainActivity.languages[i].equals("???????????????")) {
            context = LocaleHelper.setLocale(adminlogin.this, "hi");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.l_o_g_i_n));
            adminphone.setHint(resources.getString(R.string.phone_number));
            btnadminlogin.setText(resources.getString(R.string.get_otp));
            newusertext.setText(resources.getString(R.string.new_user));
            signupadmin.setText(resources.getString(R.string.sign_up));
        }
        if (MainActivity.languages[i].equals("???????????????")) {
            context = LocaleHelper.setLocale(adminlogin.this, "bn");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.l_o_g_i_n));
            adminphone.setHint(resources.getString(R.string.phone_number));
            btnadminlogin.setText(resources.getString(R.string.get_otp));
            newusertext.setText(resources.getString(R.string.new_user));
            signupadmin.setText(resources.getString(R.string.sign_up));
        }

        if (MainActivity.languages[i].equals("???????????????")) {
            context = LocaleHelper.setLocale(adminlogin.this, "mr");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.l_o_g_i_n));
            adminphone.setHint(resources.getString(R.string.phone_number));
            btnadminlogin.setText(resources.getString(R.string.get_otp));
            newusertext.setText(resources.getString(R.string.new_user));
            signupadmin.setText(resources.getString(R.string.sign_up));
        }
        if (MainActivity.languages[i].equals("??????????????????")) {
            context = LocaleHelper.setLocale(adminlogin.this, "te");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.l_o_g_i_n));
            adminphone.setHint(resources.getString(R.string.phone_number));
            btnadminlogin.setText(resources.getString(R.string.get_otp));
            newusertext.setText(resources.getString(R.string.new_user));
            signupadmin.setText(resources.getString(R.string.sign_up));
        }

        if (MainActivity.languages[i].equals("???????????????")) {
            context = LocaleHelper.setLocale(adminlogin.this, "ta");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.l_o_g_i_n));
            adminphone.setHint(resources.getString(R.string.phone_number));
            btnadminlogin.setText(resources.getString(R.string.get_otp));
            newusertext.setText(resources.getString(R.string.new_user));
            signupadmin.setText(resources.getString(R.string.sign_up));
        }

        if (MainActivity.languages[i].equals("?????????????????????")) {
            context = LocaleHelper.setLocale(adminlogin.this, "gu");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.l_o_g_i_n));
            adminphone.setHint(resources.getString(R.string.phone_number));
            btnadminlogin.setText(resources.getString(R.string.get_otp));
            newusertext.setText(resources.getString(R.string.new_user));
            signupadmin.setText(resources.getString(R.string.sign_up));
        }
    }
}