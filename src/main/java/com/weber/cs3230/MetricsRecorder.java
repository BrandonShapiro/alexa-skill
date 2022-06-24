package com.weber.cs3230;

import com.google.gson.Gson;
import org.springframework.http.HttpMethod;

public class MetricsRecorder {

    public void saveMetric(String eventName) {
        Metric metric = new Metric();
        metric.setEventName(eventName);
        metric.setAppName("brandon_alexa_app");
        final String json = new Gson().toJson(metric);
        final String urlString = "https://alexa-ghost.herokuapp.com/metric";
            Metric returnedMetric = new HttpCommunicator().communicate(HttpMethod.POST, urlString, json, Metric.class);

    }
}
