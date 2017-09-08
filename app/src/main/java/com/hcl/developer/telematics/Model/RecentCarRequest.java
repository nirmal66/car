package com.hcl.developer.telematics.Model;

/**
 * Created by nirmal.ku on 9/7/2017.
 */

public class RecentCarRequest
{

    private String userName;
    private String date;
    private String time;
    private String from;
    private String to;

    public RecentCarRequest(String userName, String date, String time, String from, String to) {
        this.userName = userName;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
