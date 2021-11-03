package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class voting_page extends AppCompatActivity {

    RecyclerVotingpageAdadpter adapter;
    RecyclerView recyclerView;
    FloatingActionButton btnnext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_page);


//        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(),R.color.primary));

        final RecyclerView recyclerView = findViewById(R.id.recyclerCandidate);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter =  new RecyclerVotingpageAdadpter(this,candidate_profile.arrCandidates);
        recyclerView.setAdapter(adapter);

        btnnext = findViewById(R.id.nextbtn);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(  getBaseContext() , voterphoto.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
