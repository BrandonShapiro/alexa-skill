package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;

import java.util.*;

public class CoachAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Jurgen Klopp is their head coach.");
        answers1.add("The current head coach is Jurgen Klopp.");
        answers1.add("Liverpool's coach is a german named Jurgen Klopp.");

        return findPossibleAnswers(answers1);
    }

    public AlexaIntent getIntent(){
        return AlexaIntent.COACH;
    }
}

