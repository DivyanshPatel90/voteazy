package com.example.voteazy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class votersignup extends AppCompatActivity {
    Button btnvotersignup;
    TextView loginvoter;
    TextView signuptext;
    TextView alreadyusertext;
    EditText voterphone;
    EditText voterAadhar;
    float v = 0;
    Context context;
    Resources resources;
    DatabaseReference voterdbref;
    DatabaseReference rootRef;
    TextInputLayout textInputLayout1;
    TextInputLayout textInputLayout2;

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
        textInputLayout1 = findViewById(R.id.textinputlayour1);
        textInputLayout2 = findViewById(R.id.textinputlayour2);

        final ProgressBar progressBar = findViewById(R.id.progressbar);
        voterdbref = FirebaseDatabase.getInstance().getReference().child("Voters");
        rootRef = FirebaseDatabase.getInstance().getReference();


//          btnvotersignup.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                  progressBar.setVisibility(View.GONE);
//                                btnvotersignup.setVisibility(View.VISIBLE);
//                                Intent intent = new Intent(getBaseContext(), voterotpverification.class);
//                                intent.putExtra("mobile", voterphone.getText().toString());
//                                intent.putExtra("aadhar", voterAadhar.getText().toString());
//                                startActivity(intent);
//              }
//          });



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
                    textInputLayout1.setError("Invalid Aadhar number");
                    Toast.makeText(getBaseContext(), "Enter Valid Aadhar Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (voterphone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                textInputLayout1.setError(null);

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
                                intent.putExtra("aadhar", voterAadhar.getText().toString());
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
        textInputLayout1.setTranslationY(300);
        textInputLayout2.setTranslationY(300);


        btnvotersignup.setAlpha(v);
        loginvoter.setAlpha(v);
        signuptext.setAlpha(v);
        voterphone.setAlpha(v);
        alreadyusertext.setAlpha(v);
        voterAadhar.setAlpha(v);
        textInputLayout1.setAlpha(v);
        textInputLayout2.setAlpha(v);


        btnvotersignup.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        loginvoter.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signuptext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        alreadyusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        voterAadhar.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        textInputLayout1.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        textInputLayout2.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();

        // Change language
        int i = (MainActivity.languageselected);
        if (MainActivity.languages[i].equals("English")) {

            context = LocaleHelper.setLocale(votersignup.this, "en");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            voterphone.setHint(resources.getString(R.string.phone_number));
            voterAadhar.setHint(resources.getString(R.string.aadhar_number));
            btnvotersignup.setText(resources.getString(R.string.verify));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            loginvoter.setText(resources.getString(R.string.login));


        }
        if (MainActivity.languages[i].equals("हिंदी")) {
            context = LocaleHelper.setLocale(votersignup.this, "hi");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            voterphone.setHint(resources.getString(R.string.phone_number));
            voterAadhar.setHint(resources.getString(R.string.aadhar_number));
            btnvotersignup.setText(resources.getString(R.string.verify));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            loginvoter.setText(resources.getString(R.string.login));
        }

        if (MainActivity.languages[i].equals("বাংলা")) {
            context = LocaleHelper.setLocale(votersignup.this, "hi");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            voterphone.setHint(resources.getString(R.string.phone_number));
            voterAadhar.setHint(resources.getString(R.string.aadhar_number));
            btnvotersignup.setText(resources.getString(R.string.verify));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            loginvoter.setText(resources.getString(R.string.login));
        }

        if (MainActivity.languages[i].equals("मराठी")) {
            context = LocaleHelper.setLocale(votersignup.this, "mr");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            voterphone.setHint(resources.getString(R.string.phone_number));
            voterAadhar.setHint(resources.getString(R.string.aadhar_number));
            btnvotersignup.setText(resources.getString(R.string.verify));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            loginvoter.setText(resources.getString(R.string.login));
        }
        if (MainActivity.languages[i].equals("తెలుగు")) {
            context = LocaleHelper.setLocale(votersignup.this, "te");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            voterphone.setHint(resources.getString(R.string.phone_number));
            voterAadhar.setHint(resources.getString(R.string.aadhar_number));
            btnvotersignup.setText(resources.getString(R.string.verify));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            loginvoter.setText(resources.getString(R.string.login));
        }
        if (MainActivity.languages[i].equals("தமிழ்")) {
            context = LocaleHelper.setLocale(votersignup.this, "ta");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            voterphone.setHint(resources.getString(R.string.phone_number));
            voterAadhar.setHint(resources.getString(R.string.aadhar_number));
            btnvotersignup.setText(resources.getString(R.string.verify));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            loginvoter.setText(resources.getString(R.string.login));
        }

        if (MainActivity.languages[i].equals("ગુજરાતી")) {
            context = LocaleHelper.setLocale(votersignup.this, "gu");
            resources = context.getResources();
            signuptext.setText(resources.getString(R.string.s_i_g_n_u_p));
            voterphone.setHint(resources.getString(R.string.phone_number));
            voterAadhar.setHint(resources.getString(R.string.aadhar_number));
            btnvotersignup.setText(resources.getString(R.string.verify));
            alreadyusertext.setText(resources.getString(R.string.already_have_an_account));
            loginvoter.setText(resources.getString(R.string.login));
        }
    }


}