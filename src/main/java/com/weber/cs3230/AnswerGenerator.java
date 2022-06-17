package com.weber.cs3230;

import java.util.*;

public abstract class AnswerGenerator {
    abstract protected String getAnswerText();
    abstract protected AlexaIntent getIntent();
    abstract protected List<String> getPossibleAnswers();
    abstract protected String getEventName();
    private final MetricsRecorder mr = new MetricsRecorder();

    public String findAnswer(){
        List<String> possibleAnswers = new ArrayList<>();
        for(String answer : getPossibleAnswers()){
            if(!answer.equals(getLastAnswer())){
                possibleAnswers.add(answer);
            }
        }
        Collections.shuffle(possibleAnswers);
        addToCache(possibleAnswers.get(0));
        mr.saveMetric(getEventName());
        return possibleAnswers.get(0);
    }

    //RESPONSE CACHE
    private final Map<AlexaIntent, String> cache = new HashMap<>();
    private String getLastAnswer(){
        return cache.getOrDefault(getIntent(), "");
    }
    private void addToCache(String answer) {
        cache.put(getIntent(), answer);
    }
}
