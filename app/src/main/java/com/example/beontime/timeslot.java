package com.example.beontime;

import androidx.annotation.NonNull;

public class timeslot {
    String begintime;
    String date;
    String endtime;

    public timeslot() {
    }

    @Override
    public String toString() {
        return "timeslot{" +
                "begintime='" + begintime + '\'' +
                ", date='" + date + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
