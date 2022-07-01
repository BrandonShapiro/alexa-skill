package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.NoAvailableAnswerException;

import java.util.*;

public class FoundedAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("LFC was founded on June 3, 1892.");
        answers.add("June 3, 1892");
        answers.add("Liverpool was founded in 1892 on June 3rd.");
        return answers;
    }
}

