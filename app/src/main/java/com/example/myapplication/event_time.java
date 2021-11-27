package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class event_time implements Serializable {
    private String Event;
    private String Time;

    protected event_time(Parcel in) {
        Event = in.readString();
        Time = in.readString();
    }


    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public event_time() {
    }

    public event_time(String event, String time) {
        Event = event;
        Time = time;
    }

}
