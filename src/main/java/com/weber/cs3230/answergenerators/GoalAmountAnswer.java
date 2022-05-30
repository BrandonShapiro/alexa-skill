package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;
import com.weber.cs3230.ResponseCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoalAmountAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer("goal_amount");
        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool scored 139 goals across all competitions.");
        answers1.add("They set their new record high of 139 goals in a single season.");
        answers1.add("139 goals were scored by Liverpool this year.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache("goal_amount", answer);

        return answer;
    }
}
