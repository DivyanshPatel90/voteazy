package com.example.voteazy;

public class CandidateModel {
    int img;
    String name,party;
    public CandidateModel(int img,String name,String party){
        this.img = img;
        this.name = name;
        this.party = party;
    }
    public CandidateModel(String name,String party){
        this.name = name;
        this.party = party;
    }
}