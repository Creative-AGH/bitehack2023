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

    @Value("${openai.apiKey}")
    private String token;
    @Value("${openai.timeout}")
    private int timeout;
    @Value("${openai.maxTokens}")
    private int maxTokens;
    private OpenAiService openAiService;
    @PostConstruct
    public void init() {
        openAiService = new OpenAiService(token, timeout);
    }

    private String splitIntoSmallerParts(String givenPrompt)
    {
        return new StringBuilder()
                .append("Podziel na mniejsze podproblemy i wypisz je od pauz :")
                .append(givenPrompt).toString();
    }
    @PostMapping("/createLearningPlanWithAi")
    public String getAiResponse(@RequestBody PromptWithEstimatedLearningTime promptWithEstimatedLearningTime) {

        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(splitIntoSmallerParts("Napisz rozprawkę na temat nauki w czasach pandemii"))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
//        return service.complete(completionRequest).getChoices().get(0).getText();
//        System.out.println(service.createCompletion(completionRequest).getChoices());
        List<CompletionChoice> choiceList = openAiService.createCompletion(completionRequest).getChoices();
        choiceList.forEach(System.out::println);

        String[] singleResponseTable= choiceList.stream().findFirst().map(CompletionChoice::getText)
                .orElse("Niestety nie potrafię pomóc").split("[0-9]+\\.");

        System.out.println("-----------------");
//                .map(CompletionChoice::toString).findFirst().orElse("No response");

        for (String s : singleResponseTable) {
            System.out.println();
            System.out.println(s);
        }
        return "dziala";
    }

}
