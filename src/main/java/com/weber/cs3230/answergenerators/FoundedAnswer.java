package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;
import com.weber.cs3230.ResponseCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoundedAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer(AlexaIntent.FOUNDED);

        List<String> answers1 = new ArrayList<>();
        answers1.add("LFC was founded on June 3, 1892.");
        answers1.add("June 3, 1892");
        answers1.add("Liverpool was founded in 1892 on June 3rd.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache(AlexaIntent.FOUNDED, answer);
        return answer;
    }
}
