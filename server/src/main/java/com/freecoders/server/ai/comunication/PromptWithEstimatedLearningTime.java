package com.freecoders.server.ai.comunication;

import lombok.Data;

@Data

public class PromptWithEstimatedLearningTime {
    private String prompt;
    private int estimatedLearningTime;
}
