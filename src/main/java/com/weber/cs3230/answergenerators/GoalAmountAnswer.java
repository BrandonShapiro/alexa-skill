package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.FindPossibleAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoalAmountAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool scored 139 goals across all competitions.");
        answers1.add("They set their new record high of 139 goals in a single season.");
        answers1.add("139 goals were scored by Liverpool this year.");

        List<String> responses = FindPossibleAnswers.possibleAnswers(answers1, "");
        Collections.shuffle(responses);
        answer = responses.get(0);

        return answer;
    }
}
