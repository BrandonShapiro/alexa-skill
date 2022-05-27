package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.FindPossibleAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;

        List<String> answers1 = new ArrayList<>();
        answers1.add("Jurgen Klopp is their head coach.");
        answers1.add("The current head coach is Jurgen Klopp.");
        answers1.add("Liverpool's coach is a german named Jurgen Klopp.");

        List<String> responses = FindPossibleAnswers.possibleAnswers(answers1, "");
        Collections.shuffle(responses);
        answer = responses.get(0);

        return answer;
    }
}
