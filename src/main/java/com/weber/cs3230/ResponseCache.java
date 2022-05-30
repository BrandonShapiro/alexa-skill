package com.weber.cs3230;

import java.util.*;

public class ResponseCache {
    private static final Map<String, String> cache = new HashMap<>();

    public static String getLastAnswer(String intentName){
        return ResponseCache.cache.getOrDefault(intentName, "");
    }
    public static void addToCache(String intentName, String answer) {
        ResponseCache.cache.put(intentName, answer);
    }
}

