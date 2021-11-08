package com.example.voteazy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class adminotpverification extends AppCompatActivity {

    Button verifybtn;
    private EditText inputcode1, inputcode2, inputcode3, inputcode4, inputcode5, inputcode6;
    private String verificationid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminotpverification);

        verifybtn = findViewById(R.id.adminvarifybtn);
        final ProgressBar progressBar = findViewById(R.id.progressbar);
        verificationid = getIntent().getStringExtra("varificationId");

        TextView txtmoblie = findViewById(R.id.txtphone);
        txtmoblie.setText(String.format(
                "OTP sent to " + "+91-%s", getIntent().getStringExtra("mobile")
        ));

        inputcode1 = findViewById(R.id.inputcode1);
        inputcode2 = findViewById(R.id.inputcode2);
        inputcode3 = findViewById(R.id.inputcode3);
        inputcode4 = findViewById(R.id.inputcode4);
        inputcode5 = findViewById(R.id.inputcode5);
        inputcode6 = findViewById(R.id.inputcode6);

        setupOtpInputs();

        verifybtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (inputcode1.getText().toString().trim().isEmpty() ||
                       inputcode2.getText().toString().trim().isEmpty() ||
                       inputcode3.getText().toString().trim().isEmpty() ||
                       inputcode4.getText().toString().trim().isEmpty() ||
                       inputcode5.getText().toString().trim().isEmpty() ||
                       inputcode6.getText().toString().trim().isEmpty()) {
                   Toast.makeText(adminotpverification.this, "Please enter valid code", Toast.LENGTH_SHORT).show();
                   return;
               }

               String code = inputcode1.getText().toString() +
                       inputcode2.getText().toString() +
                       inputcode3.getText().toString() +
                       inputcode4.getText().toString() +
                       inputcode5.getText().toString() +
                       inputcode6.getText().toString();

               if (verificationid != null) {
                   progressBar.setVisibility(View.VISIBLE);
                   verifybtn.setVisibility(View.INVISIBLE);
                   PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                           verificationid,
                           code
                   );
                   FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   progressBar.setVisibility(View.GONE);
                                   verifybtn.setVisibility(View.VISIBLE);
                                   if(task.isSuccessful()){
                                       Intent intent = new Intent(getBaseContext(), adminpage.class);
                                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                       startActivity(intent);
                                       finish();
                                   }
                                   else{
                                       Toast.makeText(adminotpverification.this,"The OTP entered is invalid",Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });

               }

           }
       });
    }

    private void setupOtpInputs() {
        inputcode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputcode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputcode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputcode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputcode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputcode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    inputcode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}