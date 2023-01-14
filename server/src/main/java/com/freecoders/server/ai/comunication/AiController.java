package com.freecoders.server.ai.comunication;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
@Data
public class AiController {

    @Value("${openai.apiKey}")
    private String token;
    @Value("${openai.timeout}")
    private int timeout;
    private OpenAiService openAiService;
    @PostConstruct
    public void init() {
        openAiService = new OpenAiService(token, timeout);
    }
    @GetMapping("/ai")
    public String getAiResponse() {

        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Napisz rozprawkę na temat nauki w czasach pandemii")
                .maxTokens(1000)
                .temperature(0.5)
                .echo(true)
                .build();
//        return service.complete(completionRequest).getChoices().get(0).getText();
//        System.out.println(service.createCompletion(completionRequest).getChoices());
        openAiService.createCompletion(completionRequest).getChoices().forEach(System.out::println);
        return "dziala";
    }

}
