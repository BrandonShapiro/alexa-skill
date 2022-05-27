package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;
import com.weber.cs3230.ResponseCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RivalAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer("rival");

        List<String> answers1 = new ArrayList<>();
        answers1.add("Everton is Liverpool's biggest rival.");
        answers1.add("The rivalry between Liverpool and Everton is unmatched.");
        answers1.add("Everton, who also reside in Merseyside, are Liverpool's rival.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache("rival", answer);

        return answer;
    }
}
