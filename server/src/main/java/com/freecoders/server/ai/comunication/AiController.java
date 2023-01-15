package com.freecoders.server.ai.comunication;

import com.freecoders.server.TimeService;
import com.freecoders.server.entites.Account;
import com.freecoders.server.entites.Availability;
import com.freecoders.server.entites.Plan;
import com.freecoders.server.entites.Task;
import com.freecoders.server.plan.dto.PlanDto;
import com.freecoders.server.plan.dto.PlanMapper;
import com.freecoders.server.repository.AccountRepository;
import com.freecoders.server.repository.PlanRepository;
import com.freecoders.server.repository.TaskRepository;
import com.theokanning.openai.completion.CompletionChoice;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
public class AiController {
    private final AiService aiService;
    private final AccountRepository accountRepository;
    private final PlanRepository planRepository;
    private final TaskRepository taskRepository;
    private final PlanMapper planMapper;

    @Transactional
    @PostMapping("/createLearningPlanWithAi")
    public ResponseEntity<PlanDto> getAiResponse(@RequestBody PromptWithEstimatedLearningTime promptWithEstimatedLearningTime) {

//        return service.complete(completionRequest).getChoices().get(0).getText();
//        System.out.println(service.createCompletion(completionRequest).getChoices());
        List<CompletionChoice> choiceList = aiService.divideInToSmallerTasks(promptWithEstimatedLearningTime.getPrompt());
        choiceList.forEach(System.out::println);

        String[] singleResponseTable = choiceList.stream().findFirst().map(CompletionChoice::getText)
                .orElse("Niestety nie potrafię pomóc").split("[0-9]+\\.");

        System.out.println("-----------------");
//                .map(CompletionChoice::toString).findFirst().orElse("No response");

        LocalDateTime deadline = promptWithEstimatedLearningTime.getDeadline();
        int estimatedLearningTime = promptWithEstimatedLearningTime.getEstimatedLearningTime();

        Account adminAccount = accountRepository.findById(1L).get();
        List<Availability> availabilities = adminAccount.getAvailabilities();
        List<LocalDateTime> localDateTimes;
        Plan plan = new Plan();
        List<Task> tasks = new ArrayList<>();
        localDateTimes = TimeService.divideTasks(availabilities, singleResponseTable.length, deadline);
        for (int i = 0; i < singleResponseTable.length; i++) {
            Task task = new Task();
            task.setQuestion(singleResponseTable[i]);
            task.setPromptContext(promptWithEstimatedLearningTime.getPrompt());
            task.setTaskDateTime(localDateTimes.get(i)); // here we get the date and time for each task
            tasks.add(task);
            System.out.println(singleResponseTable[i]);
            taskRepository.save(task);
        }
        plan.setTasks(tasks);
        adminAccount.getPlan().add(plan);
        Plan savedPlan = planRepository.save(plan);
        Account save = accountRepository.save(adminAccount);
        return ResponseEntity.ok(planMapper.mapPlanToPlanDto(savedPlan));
    }

}
