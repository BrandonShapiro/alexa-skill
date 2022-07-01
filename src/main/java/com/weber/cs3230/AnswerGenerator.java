package com.weber.cs3230;

import java.util.*;

public abstract class AnswerGenerator {
    abstract protected List<String> getPossibleAnswers(String intent);
    private final MetricsRecorder mr = new MetricsRecorder();

    public String findAnswer(AlexaIntent alexaIntent) throws NoAvailableAnswerException {
        List<String> possibleAnswers = new ArrayList<>();
        if(getPossibleAnswers(alexaIntent.getIntentName()).size() > 1) {
            for (String answer : getPossibleAnswers(alexaIntent.getIntentName())) {
                if (!answer.equals(getLastAnswer(alexaIntent))) {
                    possibleAnswers.add(answer);
                }
            }
            if(possibleAnswers.size() == 0){
                throw new NoAvailableAnswerException(alexaIntent);
            }
            else {
                Collections.shuffle(possibleAnswers);
            }
        }
        addToCache(alexaIntent, possibleAnswers.get(0));
        mr.saveMetric("\"" + possibleAnswers.get(0) + "\" given as answer for " + alexaIntent.getIntentName());
        return possibleAnswers.get(0);
    }

    //RESPONSE CACHE
    private final Map<AlexaIntent, String> cache = new HashMap<>();
    private String getLastAnswer(AlexaIntent alexaIntent){
        return cache.getOrDefault(alexaIntent, "");
    }
    private void addToCache(AlexaIntent alexaIntent, String answer) {
        cache.put(alexaIntent, answer);
    }
}
