package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class ColorAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("Liverpool's main color is Red.");
        answers1.add("Their colors are Red, Green, and Gold.");
        answers1.add("Liverpool's home color is always Red.");
        return findPossibleAnswers(answers1);
    }
    public AlexaIntent getIntent(){
        return AlexaIntent.COLOR;
    }
}

