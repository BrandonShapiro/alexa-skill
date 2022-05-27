package com.weber.cs3230;

import java.util.Map;

public class LastAnswer {
    public static Map<String, String> responseCache;

    public static String getLastAnswer(String intent){
        return LastAnswer.responseCache.getOrDefault(intent, "");
    }
}
