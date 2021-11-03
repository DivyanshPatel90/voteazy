package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adminsignup extends AppCompatActivity {

    Button btnadminsignup;
    TextView adminlogin;
    EditText aadharadmin;
    EditText adminphone;
    EditText adminotp;
    TextView sendotptxt;
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
        sendotptxt = findViewById(R.id.resendotp);
        adminotp = findViewById(R.id.otp);
        alreadyusertext  = findViewById(R.id.text);
        signuptext = findViewById(R.id.Welcome);
        float v = 0;

       btnadminsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aadhar number check;
//                String num = aadharadmin.getText().toString();
//                boolean result = Verhoeff.validateVerhoeff(num);
//                String  msg = String.valueOf(result);
//                if(msg == "true"){
////                    Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"Enter valid Aadhar number.",Toast.LENGTH_SHORT).show();
//                }

                Intent intent = new Intent(getBaseContext(),result_page.class);
                startActivity(intent);
            }
        });

       adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(  getBaseContext() , adminlogin.class);
                startActivity(intent);
                finish();
            }
        });



        btnadminsignup.setTranslationY(300);
        adminlogin.setTranslationY(300);
        signuptext.setTranslationY(300);
        sendotptxt.setTranslationY(300);
        adminphone.setTranslationY(300);
        adminotp.setTranslationY(300);
        alreadyusertext.setTranslationY(300);
        aadharadmin.setTranslationY(300);


        btnadminsignup.setAlpha(v);
        adminlogin.setAlpha(v);
        signuptext.setAlpha(v);
        sendotptxt.setAlpha(v);
        adminphone.setAlpha(v);
        adminotp.setAlpha(v);
        alreadyusertext.setAlpha(v);
        aadharadmin.setAlpha(v);

        btnadminsignup.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminlogin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        signuptext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        sendotptxt.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminphone.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        adminotp.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        alreadyusertext.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
        aadharadmin.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();
    }
}