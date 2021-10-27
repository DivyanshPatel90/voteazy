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
//        getWindow().setStatusBarColor(ContextCompat.getColor(getBaseContext(),R.color.accent));

        final RecyclerView recyclerView = findViewById(R.id.recyclerCandidate);
        addbtn  = findViewById(R.id.addbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog  = new Dialog(candidate_profile.this);
                dialog.setContentView(R.layout.candidate_form);

                final EditText candidateName = dialog.findViewById(R.id.candidate_name);
                final EditText partyName = dialog.findViewById(R.id.partyname);
                final EditText aboutcandidate = dialog.findViewById(R.id.about);
                Button btnAction = dialog.findViewById(R.id.candidateActionbtn);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "",party = "",about = "";
                        if(!candidateName.getText().toString().equals("")){
                            name  = candidateName.getText().toString();
                        }
                        else{
                            Toast.makeText(candidate_profile.this, "Please Enter Candidate Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!partyName.getText().toString().equals("")){
                            party = partyName.getText().toString();
                        }
                        else{
                            Toast.makeText(candidate_profile.this, "Please Enter Party Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!aboutcandidate.getText().toString().equals("")){
                            about = aboutcandidate.getText().toString();
                        }
                        else{
                            Toast.makeText(candidate_profile.this, "Please Enter about candidate", Toast.LENGTH_SHORT).show();
                        }






                        arrCandidates.add(new CandidateModel(R.drawable.avatar,name, party,about));
                        adapter.notifyItemInserted(arrCandidates.size()-1);
                        recyclerView.scrollToPosition(arrCandidates.size()-1);
                        dialog.dismiss();
                    }

                });

                dialog.show();

            }
        });

        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Narendra modi", "Bhartiya Janta Party " ,"Narendra Damodardas Modi is an Indian politician serving as the 14th and current prime minister of India since 2014. Modi was the chief minister of Gujarat from 2001 to 2014 and is the Member of Parliament from Varanasi. He is a member of the Bharatiya Janata Party and its National Democratic Alliance"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Rahul Gandhi", "Indian National Congress","Rahul Gandhi is an Indian politician and a member of the Indian Parliament, representing the constituency of Wayanad, Kerala in the 17th Lok Sabha. A member of the Indian National Congress, he served as the President of the Indian National Congress from 16 December 2017 to 3 July 2019"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Arvind kejriwal", "Aam Aadmi Party","Arvind Kejriwal is an Indian politician and a former bureaucrat who is the current and 7th Chief Minister of Delhi since February 2015. He was also the Chief Minister of Delhi from December 2013 to February 2014, stepping down after 49 days of assuming power"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Mamata Banerjee", "All India Trinamool Congress","Mamata Banerjee is an Indian politician and academic who is serving as the ninth and current chief minister of the Indian state of West Bengal since 2011, the first woman to hold the office."));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Mayawati", "Bahujan Samaj Party","Mayawati is an Indian politician and social reformer. She has served four separate terms as Chief Minister of Uttar Pradesh"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Sitaram Yechury", "Communist Party of India","Sitaram Yechury is an Indian politician and a leader of the Communist Party of India. He is a member of the Politburo of the Communist Party of India, the largest communist party of India"));
        arrCandidates.add(new CandidateModel(R.drawable.avatar,"Conrad Sangma", "National People's Party","Conrad Kongkal Sangma is an Indian politician who is the 12th and current Chief Minister of the State of Meghalaya. He assumed presidency of the National People's Party in 2016 after the death of his father and former Chief Minister P. A. Sangma. He was also the Member of Parliament from Tura"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerCandidateAdapter(this,arrCandidates);
        recyclerView.setAdapter(adapter);

    }
}