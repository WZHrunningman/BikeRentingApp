package com.example.mania.bikerentingapp;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

public class Bill extends BmobObject {

    private String username;
    private String bikenumber;
    private int time;
    private int money;



    public void setMoney(int money) {
        this.money = money;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBikenumber(String bikenumber) {
        this.bikenumber = bikenumber;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public String getBikenumber() {
        return bikenumber;
    }

    public int getMoney() {
        return money;
    }

    public int getTime() {
        return time;
    }


}
