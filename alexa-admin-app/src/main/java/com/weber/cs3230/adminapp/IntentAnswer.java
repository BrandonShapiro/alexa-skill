package com.weber.cs3230.adminapp;

public class IntentAnswer {

    private long id;
    private String name;
    private String dateAdded;

    public IntentAnswer(String name, String dateAdded){
        this.name = name;
        this.dateAdded = dateAdded;
    }

    public IntentAnswer() {
        this.name = "";
        this.dateAdded = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public String getDateAdded() {return dateAdded;}
}
