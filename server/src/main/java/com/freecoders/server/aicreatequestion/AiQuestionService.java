package com.freecoders.server.aicreatequestion;

import com.freecoders.server.ai.comunication.AiService;
import com.freecoders.server.entites.Plan;
import com.freecoders.server.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiQuestionService {
    private final AiService aiService;
    private final PlanRepository planRepository;

    void changeTaskToQuestion(Long id) {
        Plan plan = planRepository.findById(id).orElse(null);


//        planRepository.findById(id).get().map(
//
//        )
//        aiService.changeTaskToQuestion(planRepository.findById(id).get());
    }
}



