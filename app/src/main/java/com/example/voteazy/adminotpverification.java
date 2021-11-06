package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminotpverification extends AppCompatActivity {

    Button verifybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminotpverification);

       verifybtn = findViewById(R.id.adminvarifybtn);

       verifybtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent =  new Intent(getBaseContext(),adminpage.class);
               startActivity(intent);
               finish();
           }
       });
    }
}