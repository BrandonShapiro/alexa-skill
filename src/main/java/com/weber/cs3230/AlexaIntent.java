package com.weber.cs3230;

import java.util.Arrays;

public enum AlexaIntent {
    BEST_TEAM("best_team"),
    GOAL_AMOUNT("goal_amount"),
    TOP_SCORER("top_scorer"),
    COACH("coach"),
    TITLES("titles"),
    RIVAL("rival"),
    BEST_PLAYER("best_player"),
    MOTTO("motto"),
    COLOR("color"),
    FOUNDED("founded"),
    EMAIL("email");


    private final String intentName;

    AlexaIntent(String intentName) {
        this.intentName = intentName;
    }

    public String getIntentName() {
        return intentName;
    }

    public static AlexaIntent getIntentFromString(String intentString) {
        return Arrays.stream(AlexaIntent.values())
                .filter(intent -> intentString.equalsIgnoreCase(intent.intentName))
                .findFirst()
                .orElse(null);
    }
}
