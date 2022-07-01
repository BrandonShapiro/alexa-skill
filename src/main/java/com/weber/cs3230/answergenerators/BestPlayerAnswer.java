package com.weber.cs3230.answergenerators;

import com.weber.cs3230.*;

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
    @Override protected List<String> getVariables() {return null;}
    @Override
    protected String getEventName() {return "Best_Player_Asked";}
}
