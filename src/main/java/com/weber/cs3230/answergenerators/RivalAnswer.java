package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class RivalAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Everton is Liverpool's biggest rival.");
        answers1.add("The rivalry between Liverpool and Everton is unmatched.");
        answers1.add("Everton, who also reside in Merseyside, are Liverpool's rival.");

        return findPossibleAnswers(answers1);
    }
    public AlexaIntent getIntent(){
        return AlexaIntent.RIVAL;
    }
}
