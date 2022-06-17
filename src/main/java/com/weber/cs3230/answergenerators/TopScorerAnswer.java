package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class TopScorerAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Mohammed Salah was the top scorer.");
        answers.add("Mo Salah scored 22 goals.");
        answers.add("Salah had the most with 22 goals.");
        return answers;
    }
    @Override
    public String getAnswerText() {return findAnswer();}
    public AlexaIntent getIntent(){return AlexaIntent.TOP_SCORER;}
    @Override
    protected String getEventName() {return "Top_Scorer_Asked";}
}
