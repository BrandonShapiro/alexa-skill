package com.weber.cs3230.answergenerators;

import com.weber.cs3230.AlexaIntent;
import com.weber.cs3230.AnswerGenerator;
import java.util.*;

public class FoundedAnswer extends AnswerGenerator {
    @Override
    public String getAnswerText() {

        List<String> answers1 = new ArrayList<>();
        answers1.add("LFC was founded on June 3, 1892.");
        answers1.add("June 3, 1892");
        answers1.add("Liverpool was founded in 1892 on June 3rd.");

        return findPossibleAnswers(answers1);
    }

    public AlexaIntent getIntent(){
        return AlexaIntent.FOUNDED;
    }
}

