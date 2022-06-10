package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.AnswerGeneratorVariables;

import java.util.*;

public class BestPlayerAnswer extends AnswerGeneratorVariables {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Mohammed Salah");
        answers.add("Trent Alexander Arnold");
        answers.add("Sadio Mane");;
        return answers;
    }
    @Override public String getAnswerText() {return super.findAnswer();}
    @Override protected List<String> getVariables() {return null;}
    public AlexaIntent getIntent(){return AlexaIntent.BEST_PLAYER;}
}
