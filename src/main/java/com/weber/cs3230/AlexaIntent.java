package com.weber.cs3230;

import com.weber.cs3230.answergenerators.*;
import java.util.Arrays;

public enum AlexaIntent {
    BEST_TEAM("best_team", new TeamAnswer()),
    GOAL_AMOUNT("goal_amount", new GoalAmountAnswer()),
    TOP_SCORER("top_scorer", new TopScorerAnswer()),
    COACH("coach", new CoachAnswer()),
    TITLES("titles", new TitlesAnswer()),
    RIVAL("rival", new RivalAnswer()),
    BEST_PLAYER("best_player", new BestPlayerAnswer()),
    MOTTO("motto", new MottoAnswer()),
    COLOR("color", new ColorAnswer()),
    FOUNDED("founded", new FoundedAnswer());


    private final String intentName;
    private final AnswerGenerator answerGenerator;

    AlexaIntent(String intentName, AnswerGenerator answerGenerator) {
        this.intentName = intentName;
        this.answerGenerator = answerGenerator;
    }

    public String getIntentName() {
        return intentName;
    }

    public AnswerGenerator getAnswerGenerator() {
        return answerGenerator;
    }

    public static AlexaIntent getIntentFromString(String intentString) {
        return Arrays.stream(AlexaIntent.values())
                .filter(intent -> intentString.equalsIgnoreCase(intent.intentName))
                .findFirst()
                .orElse(null);
    }
}
