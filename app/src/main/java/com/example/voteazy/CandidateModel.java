package com.example.voteazy;

import android.net.Uri;
import android.widget.ImageView;

import java.net.URI;

public class CandidateModel {
    Uri img;
    String name,party,about;
    public CandidateModel(Uri img,String name,String party ,String about){
        this.img = img;
        this.name = name;
        this.party = party;
        this.about = about;
    }
    public CandidateModel(String name,String party,String about){
        this.name = name;
        this.party = party;
        this.about = about;
    }
    public CandidateModel(Uri img ,String name,String party){
        this.name = name;
        this.party = party;
        this.img = img;
    }
    public CandidateModel(Uri img ){
        this.img = img;
    }
}