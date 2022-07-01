package com.weber.cs3230;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBAnswerGenerator extends AnswerGenerator {
    private final AlexaDAO alexaDAO;
    @Autowired
    DBAnswerGenerator(AlexaDAO alexaDAO){
        this.alexaDAO = alexaDAO;
    }

    @Override
    protected List<String> getPossibleAnswers(String intent) {
        return alexaDAO.getAnswersForIntent(intent);
    }
}
