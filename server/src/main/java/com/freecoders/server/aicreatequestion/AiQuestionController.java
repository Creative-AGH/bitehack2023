package com.freecoders.server.aicreatequestion;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AiQuestionController {
    private final AiQuestionService aiQuestionService;
@PostMapping("/aiquestion/{id}")
    public void changeTaskToQuestion(@PathVariable Long id)
    {
        aiQuestionService.changeTaskToQuestion(id);
    }
}
