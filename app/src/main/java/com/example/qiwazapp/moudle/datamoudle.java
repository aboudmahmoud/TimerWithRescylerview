package com.example.qiwazapp.moudle;

import android.widget.Button;

public class datamoudle
{
    private  int img;
    private String days,hours,mints,secend;

    public datamoudle(int img) {
        this.img = img;
    }

    public datamoudle(int img, String days, String hours, String mints, String secend) {
        this.img = img;
        this.days = days;
        this.hours = hours;
        this.mints = mints;
        this.secend = secend;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMints() {
        return mints;
    }

    public void setMints(String mints) {
        this.mints = mints;
    }

    public String getSecend() {
        return secend;
    }

    public void setSecend(String secend) {
        this.secend = secend;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


}
