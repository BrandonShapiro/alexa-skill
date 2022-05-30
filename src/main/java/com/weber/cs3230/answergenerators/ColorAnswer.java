package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;
import com.weber.cs3230.ResponseCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColorAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer(AlexaIntent.COLOR);

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool's main color is Red.");
        answers1.add("Their colors are Red, Green, and Gold.");
        answers1.add("Liverpool's home color is always Red.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache(AlexaIntent.COLOR, answer);
        return answer;
    }
}
