package com.freecoders.server.ai.comunication;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class PromptWithEstimatedLearningTime {
    private String prompt;
    private int estimatedLearningTime;
    private LocalDateTime deadline;

}
