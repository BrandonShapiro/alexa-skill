package com.weber.cs3230;

public enum AlexaIntent {
    QUESTION_1("question1"),
    QUESTION_2("question2");

    private final String intentName;

    AlexaIntent(String intentName) {
        this.intentName = intentName;
    }

    public static AlexaIntent getIntentFromString(String intentString) {
        for (AlexaIntent alexaIntent : AlexaIntent.values()) {
            if (alexaIntent.intentName.equalsIgnoreCase(intentString)) {
                return alexaIntent;
            }
        }
        return null;
    }
}
