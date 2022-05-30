package com.weber.cs3230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PossibleAnswers {

    public List<String> answers;
    public String lastAnswer;

    public PossibleAnswers(List<String> answers, String lastAnswer) {
        this.answers = answers;
        this.lastAnswer = lastAnswer;
    }

    public static List<String> find(List<String> allAnswers, String lastAnswer){
        List<String> possibleAnswers = new ArrayList<>();
        for(String answer : allAnswers){
            if(!answer.equals(lastAnswer)){
                possibleAnswers.add(answer);
            }
        }
        Collections.shuffle(possibleAnswers);
        return possibleAnswers;
    }
}
