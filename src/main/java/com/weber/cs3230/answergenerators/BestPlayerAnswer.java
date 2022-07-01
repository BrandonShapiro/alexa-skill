package com.weber.cs3230.answergenerators;

import com.weber.cs3230.*;

import java.util.*;

public class BestPlayerAnswer extends AnswerGenerator {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Mohammed Salah");
        answers.add("Trent Alexander Arnold");
        answers.add("Sadio Mane");;

        return answers;
    }
}
