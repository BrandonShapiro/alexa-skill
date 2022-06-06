package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.AnswerGeneratorVariables;

import java.util.*;

public class TitlesAnswer extends AnswerGeneratorVariables {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool has won the title 19 times.");
        answers1.add("Liverpool have achieved 19 league titles.");
        answers1.add("With their most recent win in 2019, Liverpool have won the league 19 times.");

        return findPossibleAnswers(answers1);
    }

    @Override
    protected List<String> getVariables() {
        return null;
    }

    public AlexaIntent getIntent(){
        return AlexaIntent.TITLES;
    }
}
