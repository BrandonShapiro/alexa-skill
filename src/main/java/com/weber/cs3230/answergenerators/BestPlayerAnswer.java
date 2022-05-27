package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.FindPossibleAnswers;
import com.weber.cs3230.LastAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestPlayerAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;
        String previousAnswer = LastAnswer.getLastAnswer("best_player");

        List<String> answers1 = new ArrayList<>();
        answers1.add("Mohammed Salah");
        answers1.add("Trent Alexander Arnold");
        answers1.add("Sadio Mane");

        List<String> responses = FindPossibleAnswers.possibleAnswers(answers1, previousAnswer);
        answer = responses.get(0);
        LastAnswer.responseCache.put("best_player", answer);

        return answer;
    }
}
