package com.example.healthyrate;

public class orgExer {
    String date;
    String from;
    String to;
    String description;



    orgExer() {
    }


    public orgExer(String date, String from, String to, String description) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
