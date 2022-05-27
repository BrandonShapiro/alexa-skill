package com.weber.cs3230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindPossibleAnswers {

    public List<String> answers;
    public String lastAnswer;

    public FindPossibleAnswers(List<String> answers, String lastAnswer) {
        this.answers = answers;
        this.lastAnswer = lastAnswer;
    }

    public static List<String> possibleAnswers(List<String> allAnswers, String lastAnswer){
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
