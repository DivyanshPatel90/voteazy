package com.example.voteazy;

public class Voters {
    String aadhar;
    String phone;

    public  Voters(String aadhar,String phone){
        this.aadhar = aadhar;
        this.phone = phone;
    }

    public String getAadhar() {
        return aadhar;
    }

    public String getPhone() {
        return phone;
    }
}
