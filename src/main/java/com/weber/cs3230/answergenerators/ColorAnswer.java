package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.FindPossibleAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColorAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool's main color is Red.");
        answers1.add("Their colors are Red, Green, and Gold.");
        answers1.add("Liverpool's home color is always Red.");

        List<String> responses = FindPossibleAnswers.possibleAnswers(answers1, "");
        Collections.shuffle(responses);
        answer = responses.get(0);

        return answer;
    }
}
