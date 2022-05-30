package com.weber.cs3230;

import java.util.*;

public class ResponseCache {
    private static final Map<AlexaIntent, String> cache = new HashMap<>();

    public static String getLastAnswer(AlexaIntent intentName){
        return ResponseCache.cache.getOrDefault(intentName, "");
    }
    public static void addToCache(AlexaIntent alexaIntent, String answer) {
        ResponseCache.cache.put(alexaIntent, answer);
    }
}

