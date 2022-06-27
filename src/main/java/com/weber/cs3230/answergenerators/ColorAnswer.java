package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.NoAvailableAnswerException;

import java.util.*;

public class ColorAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Liverpool's main color is Red.");
        answers.add("Their colors are Red, Green, and Gold.");
        answers.add("Liverpool's home color is always Red.");

        return answers;
    }

    @Override
    public String getAnswerText() throws NoAvailableAnswerException {return findAnswer();}
    public AlexaIntent getIntent(){return AlexaIntent.COLOR;}
    @Override
    protected String getEventName() {return "Color_Asked";}
}

