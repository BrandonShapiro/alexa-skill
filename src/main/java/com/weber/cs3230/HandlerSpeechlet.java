package com.weber.cs3230;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.*;
import com.weber.cs3230.dto.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandlerSpeechlet implements SpeechletV2 {
    AlexaUtils alexaUtils = new AlexaUtils("Ask another question about LFC!");
    private final AlexaIntentHandler alexaIntentHandler;
    @Autowired
    public HandlerSpeechlet(AlexaIntentHandler alexaIntentHandler) {
        this.alexaIntentHandler = alexaIntentHandler;
    }

    @Override public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {}
    @Override public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {}

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        String title = "LFC knowledge base";
        String text = "Ask anything about Liverpool FC";
        return alexaUtils.getOnLaunchResponse(requestEnvelope.getSession(), title,text);
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        Answer answer = alexaIntentHandler.handleIntent(requestEnvelope.getRequest().getIntent().getName());
        String title = "LFC";
        if(answer != null){
            return alexaUtils.getNormalResponse(requestEnvelope.getSession(), title, answer.getText());
        }
        else{
            return alexaUtils.getUnrecognizedResponse(requestEnvelope.getSession(), title, "Unrecognized");
        }
    }
}
