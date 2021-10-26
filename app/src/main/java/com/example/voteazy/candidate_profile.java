package com.example.voteazy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class candidate_profile extends AppCompatActivity {


    static  ArrayList<CandidateModel> arrCandidates  = new ArrayList<>();
    RecyclerCandidateAdapter adapter;
    FloatingActionButton addbtn;
    RecyclerView recyclerView;
     static  String  temp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_profile);
        temp = "Divyansh";
        //Changing Action Bar color
        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(),R.color.accent));

        final RecyclerView recyclerView = findViewById(R.id.recyclerCandidate);
        addbtn  = findViewById(R.id.addbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog  = new Dialog(candidate_profile.this);
                dialog.setContentView(R.layout.candidate_form);

                final EditText candidateName = dialog.findViewById(R.id.candidate_name);
                final EditText partyName = dialog.findViewById(R.id.partyname);
                Button btnAction = dialog.findViewById(R.id.candidateActionbtn);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "",party = "";
                        if(!candidateName.getText().toString().equals("")){
                            name  = candidateName.getText().toString();
                        }
                        else{
                            Toast.makeText(candidate_profile.this, "Please Enter Candidate Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!candidateName.getText().toString().equals("")){
                            party = partyName.getText().toString();
                        }
                        else{
                            Toast.makeText(candidate_profile.this, "Please Enter Party Name", Toast.LENGTH_SHORT).show();
                        }

                        arrCandidates.add(new CandidateModel(R.drawable.avatar,name, party));
                        adapter.notifyItemInserted(arrCandidates.size()-1);
                        recyclerView.scrollToPosition(arrCandidates.size()-1);
                        dialog.dismiss();
                    }

                });

                dialog.show();

            }
        });

        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Narendra modi", "Bhartiya Janta Party"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Rahul Gandhi", "Indian National Congress"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Arvind kejriwal", "Aam Aadmi Party"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Mamata Banerjee", "All India Trinamool Congress"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Mayawati", "Bahujan Samaj Party"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Sitaram Yechury", "Communist Party of India"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Conrad Sangma", "National People's Party"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerCandidateAdapter(this,arrCandidates);
        recyclerView.setAdapter(adapter);

    }
}