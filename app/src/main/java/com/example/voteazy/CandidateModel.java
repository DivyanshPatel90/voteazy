package com.example.voteazy;

public class CandidateModel {
    int img;
    String name,party,about;

    public CandidateModel(int img,String name,String party ,String about){
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
    public CandidateModel(int img ,String name,String party){
        this.name = name;
        this.party = party;
        this.img = img;
    }
}