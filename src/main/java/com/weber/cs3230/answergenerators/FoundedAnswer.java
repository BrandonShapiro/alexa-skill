package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.FindPossibleAnswers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoundedAnswer implements AnswerGenerator {
    @Override
    public String getAnswerText() {
        String answer;

        List<String> answers1 = new ArrayList<>();
        answers1.add("LFC was founded on June 3, 1892.");
        answers1.add("June 3, 1892");
        answers1.add("Liverpool was founded in 1892 on June 3rd.");

        List<String> responses = FindPossibleAnswers.possibleAnswers(answers1, "");
        Collections.shuffle(responses);
        answer = responses.get(0);

        return answer;
    }
}
