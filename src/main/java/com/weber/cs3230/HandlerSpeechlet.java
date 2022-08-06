package com.weber.cs3230;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.weber.cs3230.dto.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandlerSpeechlet implements SpeechletV2 {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AlexaUtils alexaUtils = new AlexaUtils("Ask another question about LFC!");
    private final AlexaIntentHandler alexaIntentHandler;
    @Autowired
    public HandlerSpeechlet(AlexaIntentHandler alexaIntentHandler) {this.alexaIntentHandler = alexaIntentHandler;}
    @Override public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
        log.info("New session started");
    }
    @Override public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
        log.info("Session ended");
    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        String title = "LFC knowledge base";
        String text = "Ask anything about Liverpool FC";
        log.info("App launched!");
        return alexaUtils.getOnLaunchResponse(requestEnvelope.getSession(), title,text);
    }
    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        final Session session = requestEnvelope.getSession();
        final Intent intent = requestEnvelope.getRequest().getIntent();

        try {
            Answer answer = alexaIntentHandler.handleIntent(intent);
            String title = "LFC Trivia";

            if (answer != null) {
                log.info("Returning normal response");
                return alexaUtils.getNormalResponse(session, title, answer.getText());
            } else {
                log.info("Returning unrecognized question response");
                title = "I don't understand, please try again.";
                return alexaUtils.getUnrecognizedResponse(session, title, "Unrecognized");
            }
        }catch(NoAvailableAnswerException e){
            String title = "No Answer Available";
            String text = "I know what you're saying, but I don't have the capacity to answer that yet.";
            log.error("NoAvailableAnswerException thrown for intent: " + intent.getName(), e);
            return alexaUtils.getOnLaunchResponse(session, title, text);
        }catch(Exception e){
            String title = "Error occurred";
            String text = "An unknown error occurred, please try again.";
            log.error("Exception thrown", e);
            return alexaUtils.getOnLaunchResponse(session, title, text);
        }
    }
}
