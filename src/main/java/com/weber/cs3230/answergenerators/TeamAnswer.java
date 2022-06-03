package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer(AlexaIntent.BEST_TEAM);

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool FC are the top team.");
        answers1.add("The best team is Liverpool!");
        answers1.add("Liverpool of course!");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache(AlexaIntent.BEST_TEAM, answer);
        return answer;
    }
}
