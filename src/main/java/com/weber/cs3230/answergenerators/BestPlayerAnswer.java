package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.AnswerGeneratorVariables;

import java.util.*;

public class BestPlayerAnswer extends AnswerGeneratorVariables {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Mohammed Salah");
        answers1.add("Trent Alexander Arnold");
        answers1.add("Sadio Mane");

        return findPossibleAnswers(answers1);
    }

    @Override
    protected List<String> getVariables() {
        return null;
    }

    public AlexaIntent getIntent(){
        return AlexaIntent.BEST_PLAYER;
    }
}
