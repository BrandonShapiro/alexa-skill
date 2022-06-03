package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.PossibleAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TitlesAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = ResponseCache.getLastAnswer(AlexaIntent.TITLES);

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool has won the title 19 times.");
        answers1.add("Liverpool have achieved 19 league titles.");
        answers1.add("With their most recent win in 2019, Liverpool have won the league 19 times.");

        List<String> responses = PossibleAnswers.find(answers1, previousAnswer);
        Collections.shuffle(responses);
        answer = responses.get(0);
        ResponseCache.addToCache(AlexaIntent.TITLES, answer);

        return answer;
    }
}
