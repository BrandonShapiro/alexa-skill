package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class GoalAmountAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Liverpool scored 139 goals across all competitions.");
        answers.add("They set their new record high of 139 goals in a single season.");
        answers.add("139 goals were scored by Liverpool this year.");
        return answers;
    }
    @Override
    public String getAnswerText() {return findAnswer();}
    public AlexaIntent getIntent(){return AlexaIntent.GOAL_AMOUNT;}
}

