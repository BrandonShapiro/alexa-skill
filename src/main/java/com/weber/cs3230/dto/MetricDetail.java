package com.weber.cs3230.dto;

public class MetricDetail {
    String eventName;
    long count;
    String mostRecentDate;

    public String getEventName() {return eventName;}

    public void setEventName(String eventName) {this.eventName = eventName;}

    public long getCount() {return count;}

    public void setCount(long count) {this.count = count;}

    public String getMostRecentDate() {return mostRecentDate;}

    public void setMostRecentDate(String mostRecentDate) {this.mostRecentDate = mostRecentDate;}

}
