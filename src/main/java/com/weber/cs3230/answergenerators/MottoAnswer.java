package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.NoAvailableAnswerException;

import java.util.*;

public class MottoAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("YNWA - You'll Never Walk Alone");
        answers.add("Liverpool's motto is You'll Never Walk Alone");
        answers.add("You'll Never Walk Alone was adopted as their motto prior to 1982.");
        return answers;
    }

    public AlexaIntent getIntent(){return AlexaIntent.MOTTO;}
    @Override
    protected String getEventName() {return "Motto_Asked";}
}
