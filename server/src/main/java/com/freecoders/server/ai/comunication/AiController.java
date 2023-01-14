package com.freecoders.server.ai.comunication;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
public class AiController {
    private final AiService aiService;


    @PostMapping("/createLearningPlanWithAi")
    public String getAiResponse(@RequestBody PromptWithEstimatedLearningTime promptWithEstimatedLearningTime) {

//        return service.complete(completionRequest).getChoices().get(0).getText();
//        System.out.println(service.createCompletion(completionRequest).getChoices());
        List<CompletionChoice> choiceList = aiService.divideInToSmallerTasks(promptWithEstimatedLearningTime.getPrompt());
        choiceList.forEach(System.out::println);

        String[] singleResponseTable= choiceList.stream().findFirst().map(CompletionChoice::getText)
                .orElse("Niestety nie potrafię pomóc").split("[0-9]+\\.");

        System.out.println("-----------------");
//                .map(CompletionChoice::toString).findFirst().orElse("No response");

        for (String s : singleResponseTable) {

            //TODO Add to task as a question to TASK
            //TODO Add to database PLAN with tasks
            //TODO Add to task Dates generated from timeService by using divideTasksWithUniqueStartTimes with actual Timetable
            System.out.println();
            System.out.println(s);
        }
        return "dziala";
    }

}
