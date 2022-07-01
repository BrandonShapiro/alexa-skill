package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import com.weber.cs3230.AnswerGeneratorVariables;
import com.weber.cs3230.NoAvailableAnswerException;

import java.util.*;

public class TitlesAnswer extends AnswerGeneratorVariables {
    @Override
    protected List<String> getPossibleAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Liverpool has won the title 19 times.");
        answers.add("Liverpool have achieved 19 league titles.");
        answers.add("With their most recent win in 2019, Liverpool have won the league 19 times.");
        return answers;
    }

    @Override
    protected List<String> getVariables() {return null;}
    public AlexaIntent getIntent(){return AlexaIntent.TITLES;}
    @Override
    protected String getEventName() {return "Titles_Asked";}
}
