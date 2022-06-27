package com.weber.cs3230;

public class NoAvailableAnswerException extends Exception {

    AlexaIntent alexaIntent;

    public NoAvailableAnswerException(AlexaIntent alexaIntent) {
        this.alexaIntent = alexaIntent;
    }

    public AlexaIntent getAlexaIntent() {
        return alexaIntent;
    }
}
