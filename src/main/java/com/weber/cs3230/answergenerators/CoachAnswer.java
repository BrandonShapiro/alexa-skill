package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class CoachAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Jurgen Klopp is their head coach.");
        answers.add("The current head coach is Jurgen Klopp.");
        answers.add("Liverpool's coach is a german named Jurgen Klopp.");
        return answers;
    }

    @Override public String getAnswerText() { return findAnswer();}
    public AlexaIntent getIntent(){
        return AlexaIntent.COACH;
    }
    @Override
    protected String getEventName() {return "Coach_Asked";}
}

