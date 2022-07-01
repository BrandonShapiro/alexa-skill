package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.NoAvailableAnswerException;

import java.util.*;

public class TeamAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Liverpool FC are the top team.");
        answers.add("The best team is Liverpool!");
        answers.add("Liverpool of course!");
        return answers;
    }

    public AlexaIntent getIntent(){return AlexaIntent.BEST_TEAM;}
    @Override
    protected String getEventName() {return "Best_Team_Asked";}
}
