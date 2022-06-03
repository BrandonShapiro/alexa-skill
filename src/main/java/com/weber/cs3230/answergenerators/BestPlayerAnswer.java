package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;

import java.util.ArrayList;
import java.util.List;

public class BestPlayerAnswer extends AnswerGenerator {
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Mohammed Salah");
        answers1.add("Trent Alexander Arnold");
        answers1.add("Sadio Mane");

        return findPossibleAnswers(answers1);
    }

    public AlexaIntent getIntent(){
        return AlexaIntent.BEST_PLAYER;
    }
}
