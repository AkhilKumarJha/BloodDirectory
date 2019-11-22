package com.example.ashish.blooddonation;

import java.io.Serializable;

/**
 * Created by infix
 * */

public class Person implements Serializable {
    private String name;
    private String mobiNo;
    private String age;
    private String address;
    private String bgroup;
    private String gender;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobiNo() {
        return mobiNo;
    }

    public void setMobiNo(String mobiNo) {
        this.mobiNo = mobiNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




}
