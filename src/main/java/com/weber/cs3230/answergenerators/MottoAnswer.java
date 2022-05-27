package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;
import com.weber.cs3230.ResponseCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MottoAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer("motto");

        List<String> answers1 = new ArrayList<>();
        answers1.add("YNWA - You'll Never Walk Alone");
        answers1.add("Liverpool's motto is \"You'll Never Walk Alone\" ");
        answers1.add("You'll Never Walk Alone was adopted as their motto prior to 1982.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache("motto", answer);

        return answer;
    }
}
