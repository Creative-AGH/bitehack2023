package com.freecoders.server.ai.comunication;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AiService {
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


    List<CompletionChoice> divideInToSmallerTasks(String prompt)
    {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(splitIntoSmallerParts(prompt))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
        return openAiService.createCompletion(completionRequest).getChoices();
    }
    private List<CompletionChoice> createRequestToOpenAi(String prompt,String command)
    {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(splitIntoSmallerParts(prompt))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
        return openAiService.createCompletion(completionRequest).getChoices();
    }

}
