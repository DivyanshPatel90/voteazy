package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class result_page extends AppCompatActivity {
    RecyclerView mrecylerview;
    RecyclerResultpageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(),R.color.primary));
        mrecylerview = findViewById(R.id.recyclerCandidate);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false);
        mrecylerview.setLayoutManager(gridLayoutManager);
        mrecylerview.setHasFixedSize(true);
        adapter = new RecyclerResultpageAdapter(this,candidate_profile.arrCandidates);
        mrecylerview.setAdapter(adapter);



    }


}