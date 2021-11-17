package com.example.voteazy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import java.util.concurrent.TimeUnit;

public class adminsignup extends AppCompatActivity {

    Button btnadminsignup;
    TextView adminlogin;
    EditText aadharadmin;
    EditText adminphone;
    TextView alreadyusertext;
    TextView signuptext;
    Context context;
    Resources resources;
    TextInputLayout textInputLayout1;
    TextInputLayout textInputLayout2;

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
        textInputLayout1 = findViewById(R.id.textinputlayour1);
        textInputLayout2 = findViewById(R.id.textinputlayour2);
        final ProgressBar progressBar = findViewById(R.id.progressbar);
        float v = 0;




//        //      change color of textlayout on worng aadhar entry
//        aadharadmin.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//                //Aadhar number check;
//                String num = aadharadmin.getText().toString();
//                boolean result = Verhoeff.validateVerhoeff(num);
//                String msg = String.valueOf(result);
//
//
//                if ((msg.equals("true")) && num.length() == 12) {
//                } else {
//
//                }
//            }
//        });


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
                    textInputLayout1.setError("Invalid Aadhar number");
                    Toast.makeText(getBaseContext(),"Enter Valid Aadhar Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(adminphone .getText().toString().trim().isEmpty()){
                    Toast.makeText(getBaseContext(),"Enter Phone Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputLayout1.setError(null);




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
//                Intent intent = new Intent(getBaseContext(), adminpage.class);
//                startActivity(intent);
//            }
//        });


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
        textInputLayout1.setTranslationY(300);
        textInputLayout2.setTranslationY(300);

        btnadminsignup.setAlpha(v);
        adminlogin.setAlpha(v);
        signuptext.setAlpha(v);
        adminphone.setAlpha(v);
        alreadyusertext.setAlpha(v);
        aadharadmin.setAlpha(v);
        textInputLayout1.setAlpha(v);
        textInputLayout2.setAlpha(v);

        btnadminsignup.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminlogin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signuptext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        alreadyusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        aadharadmin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        textInputLayout1.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        textInputLayout2.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
                // Change language

        int i = (MainActivity.languageselected);

        if (MainActivity.languages[i].equals("English")) {

            context = LocaleHelper.setLocale(adminsignup.this, "en");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            adminphone.setHint(resources.getString(R.string.phone_number));
            aadharadmin.setHint(resources.getString(R.string.aadhar_number));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            adminlogin.setText(resources.getString(R.string.login));
            btnadminsignup.setText(resources.getString(R.string.get_otp));

        }
        if (MainActivity.languages[i].equals("हिंदी")) {
            context = LocaleHelper.setLocale(adminsignup.this, "hi");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            adminphone.setHint(resources.getString(R.string.phone_number));
            aadharadmin.setHint(resources.getString(R.string.aadhar_number));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            adminlogin.setText(resources.getString(R.string.login));
            btnadminsignup.setText(resources.getString(R.string.get_otp));
        }
        if (MainActivity.languages[i].equals("বাংলা")) {
            context = LocaleHelper.setLocale(adminsignup.this, "bn");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            adminphone.setHint(resources.getString(R.string.phone_number));
            aadharadmin.setHint(resources.getString(R.string.aadhar_number));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            adminlogin.setText(resources.getString(R.string.login));
            btnadminsignup.setText(resources.getString(R.string.get_otp));
        }
        if (MainActivity.languages[i].equals("मराठी")) {
            context = LocaleHelper.setLocale(adminsignup.this, "mr");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            adminphone.setHint(resources.getString(R.string.phone_number));
            aadharadmin.setHint(resources.getString(R.string.aadhar_number));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            adminlogin.setText(resources.getString(R.string.login));
            btnadminsignup.setText(resources.getString(R.string.get_otp));
        }
        if (MainActivity.languages[i].equals("తెలుగు")) {
            context = LocaleHelper.setLocale(adminsignup.this, "te");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            adminphone.setHint(resources.getString(R.string.phone_number));
            aadharadmin.setHint(resources.getString(R.string.aadhar_number));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            adminlogin.setText(resources.getString(R.string.login));
            btnadminsignup.setText(resources.getString(R.string.get_otp));
        }
        if (MainActivity.languages[i].equals("தமிழ்")) {
            context = LocaleHelper.setLocale(adminsignup.this, "ta");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            adminphone.setHint(resources.getString(R.string.phone_number));
            aadharadmin.setHint(resources.getString(R.string.aadhar_number));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            adminlogin.setText(resources.getString(R.string.login));
            btnadminsignup.setText(resources.getString(R.string.get_otp));
        }

        if (MainActivity.languages[i].equals("ગુજરાતી")) {
            context = LocaleHelper.setLocale(adminsignup.this, "gu");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            adminphone.setHint(resources.getString(R.string.phone_number));
            aadharadmin.setHint(resources.getString(R.string.aadhar_number));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            adminlogin.setText(resources.getString(R.string.login));
            btnadminsignup.setText(resources.getString(R.string.get_otp));
        }
    }
}