package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class TeamAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool FC are the top team.");
        answers1.add("The best team is Liverpool!");
        answers1.add("Liverpool of course!");
        return findPossibleAnswers(answers1);
    }
    public AlexaIntent getIntent(){
        return AlexaIntent.BEST_TEAM;
    }
}
