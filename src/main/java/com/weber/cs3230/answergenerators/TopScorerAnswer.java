package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class TopScorerAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Mohammed Salah was the top scorer.");
        answers1.add("Mo Salah scored 22 goals.");
        answers1.add("Salah had the most with 22 goals.");

        return findPossibleAnswers(answers1);
    }
    public AlexaIntent getIntent(){
        return AlexaIntent.TOP_SCORER;
    }
}
