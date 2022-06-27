package com.weber.cs3230;

import com.weber.cs3230.dto.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class AlexaIntentHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public Answer handleIntent(@PathVariable String intentString) throws NoAvailableAnswerException {
        AlexaIntent intent = AlexaIntent.getIntentFromString(intentString);
        AnswerGenerator answerGenerator = intent.getAnswerGenerator();
        log.info("generated new intent: " + intent.getIntentName());
        return new Answer(answerGenerator.getAnswerText());

    }
}
