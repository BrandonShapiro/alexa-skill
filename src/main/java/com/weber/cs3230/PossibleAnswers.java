package com.weber.cs3230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PossibleAnswers {

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
