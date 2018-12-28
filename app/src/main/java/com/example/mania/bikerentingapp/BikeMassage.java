package com.example.mania.bikerentingapp;

import cn.bmob.v3.BmobObject;

public class BikeMassage extends BmobObject {

    private String bikenumber;

    public String getBikenumber() {
        return bikenumber;
    }

    public void setBikenumber(String bikenumber) {
        this.bikenumber = bikenumber;
    }
}
