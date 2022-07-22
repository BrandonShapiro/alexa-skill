package com.weber.cs3230;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MetricsRecorder {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final ExecutorService executorService;

    public MetricsRecorder(){
        this.executorService = Executors.newCachedThreadPool();
    }
    public void saveMetric(String eventName) {
        executorService.submit(()-> {
            Metric metric = new Metric();
            metric.setEventName(eventName);
            metric.setAppName("brandon_alexa_app");
            final String json = new Gson().toJson(metric);
            final String urlString = "https://alexa-ghost.herokuapp.com/metric";
            try {
                Metric returnedMetric = new HttpCommunicator().communicate(HttpMethod.POST, urlString, json, Metric.class);
                log.info("Saved a new metric with ID: " + returnedMetric.getMetricID());
            }catch(Exception e){
                log.error("Error with HTTP Communicator.", e);
            }
        });
    }
}
