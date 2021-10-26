package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class voting_page extends AppCompatActivity {

    RecyclerVotingpageAdadpter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_page);
        final RecyclerView recyclerView = findViewById(R.id.recyclerCandidate);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter =  new RecyclerVotingpageAdadpter(this,candidate_profile.arrCandidates);
        recyclerView.setAdapter(adapter);

    }
}
