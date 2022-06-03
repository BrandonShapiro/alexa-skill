package com.weber.cs3230;

import java.util.*;

public abstract class AnswerGenerator {
    abstract protected String getAnswerText();
    abstract protected AlexaIntent getIntent();

    public String findPossibleAnswers(List<String> allAnswers){
        List<String> possibleAnswers = new ArrayList<>();
        for(String answer : allAnswers){
            if(!answer.equals(getLastAnswer(getIntent()))){
                possibleAnswers.add(answer);
            }
        }
        Collections.shuffle(possibleAnswers);
        addToCache(getIntent(), possibleAnswers.get(0));
        return possibleAnswers.get(0);
    }

    //RESPONSE CACHE
    private final Map<AlexaIntent, String> cache = new HashMap<>();

    private String getLastAnswer(AlexaIntent intentName){
        return cache.getOrDefault(getIntent(), "");
    }
    private void addToCache(AlexaIntent alexaIntent, String answer) {
        cache.put(getIntent(), answer);
    }
}
