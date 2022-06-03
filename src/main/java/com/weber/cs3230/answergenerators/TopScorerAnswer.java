package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopScorerAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer(AlexaIntent.TOP_SCORER);

        List<String> answers1 = new ArrayList<>();
        answers1.add("Mohammed Salah was the top scorer.");
        answers1.add("Mo Salah scored 22 goals.");
        answers1.add("Salah had the most with 22 goals.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache(AlexaIntent.TOP_SCORER, answer);

        return answer;
    }
}
