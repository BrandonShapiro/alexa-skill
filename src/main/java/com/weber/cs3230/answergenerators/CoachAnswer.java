package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;
import com.weber.cs3230.ResponseCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer(AlexaIntent.COACH);

        List<String> answers1 = new ArrayList<>();
        answers1.add("Jurgen Klopp is their head coach.");
        answers1.add("The current head coach is Jurgen Klopp.");
        answers1.add("Liverpool's coach is a german named Jurgen Klopp.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache(AlexaIntent.COACH, answer);

        return answer;
    }
}
