package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class MottoAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("YNWA - You'll Never Walk Alone");
        answers1.add("Liverpool's motto is \"You'll Never Walk Alone\" ");
        answers1.add("You'll Never Walk Alone was adopted as their motto prior to 1982.");

        return findPossibleAnswers(answers1);
    }
    public AlexaIntent getIntent(){
        return AlexaIntent.MOTTO;
    }
}
