package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class GoalAmountAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool scored 139 goals across all competitions.");
        answers1.add("They set their new record high of 139 goals in a single season.");
        answers1.add("139 goals were scored by Liverpool this year.");

        return findPossibleAnswers(answers1);
    }
    public AlexaIntent getIntent(){
        return AlexaIntent.GOAL_AMOUNT;
    }
}

