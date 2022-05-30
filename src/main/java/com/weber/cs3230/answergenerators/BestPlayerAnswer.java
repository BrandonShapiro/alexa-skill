package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;
import com.weber.cs3230.ResponseCache;

import java.util.ArrayList;
import java.util.List;

public class BestPlayerAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer(AlexaIntent.BEST_PLAYER);

        List<String> answers1 = new ArrayList<>();
        answers1.add("Mohammed Salah");
        answers1.add("Trent Alexander Arnold");
        answers1.add("Sadio Mane");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        answer = responses.get(0);
        ResponseCache.addToCache(AlexaIntent.BEST_PLAYER, answer);

        return answer;
    }
}
