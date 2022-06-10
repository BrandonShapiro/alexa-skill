package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class RivalAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Everton is Liverpool's biggest rival.");
        answers.add("The rivalry between Liverpool and Everton is unmatched.");
        answers.add("Everton, who also reside in Merseyside, are Liverpool's rival.");
        return answers;
    }
    @Override
    public String getAnswerText() {return findAnswer();}
    public AlexaIntent getIntent(){return AlexaIntent.RIVAL;}
}
