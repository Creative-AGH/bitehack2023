package com.freecoders.server.ai.comunication;

import com.freecoders.server.askai.RequestTaskDto;
import com.freecoders.server.entites.Task;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
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

    private String splitIntoSmallerParts(String givenPrompt) {
        return new StringBuilder()
                .append("Podziel na mniejsze podproblemy i wypisz je od pauz :")
                .append(givenPrompt).toString();
    }

    private String checkIfGivenAnswerIsCorrect(String givenPrompt) {
        return "Odpowiedz tylko TAK lub NIE czy poniższa odpowiedź poprawnie odpowiada na przedstawione pytanie ?: " +
                "Pytanie: " + givenPrompt + "\n" +
                "Odpowiedź: ";
//                .append(givenPrompt)
//                .append("Odpowiedz tak lub nie")
//                .append(givenAnswer).toString();
    }

    private String createQuestionBasedOnContext(String context, String sentense) {
        return "Zadaj jedno pytanie które dobrze opisuje zdanie " + sentense + "odpowiedz na podstawie podanego kontekstu wcześniejszej rozmowy : " + context+"~~~~";
    }


    private String changeTaskToQuestion(Task task) {

        return createQuestionBasedOnContext(task.getPromptContext(), task.getSentence());
    }
    List<CompletionChoice> changeTaskSentenceToQuestion(Task task) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(changeTaskToQuestion(task))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
        return openAiService.createCompletion(completionRequest).getChoices();
    }
    List<CompletionChoice> divideInToSmallerTasks(String prompt) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(splitIntoSmallerParts(prompt))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
        return openAiService.createCompletion(completionRequest).getChoices();
    }

    public List<CompletionChoice> createRequestToOpenAi(RequestTaskDto requestTaskDto) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(checkIfGivenAnswerIsCorrect(new String(requestTaskDto.getQuestion())))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
        System.out.println("PROMT = " + requestTaskDto.getQuestion());
        System.out.println(completionRequest.getPrompt());
//        System.out.println(completionRequest.get());
        return openAiService.createCompletion(completionRequest).getChoices();
    }

    private List<CompletionChoice> createRequestToOpenAi(String prompt, String command) {
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(splitIntoSmallerParts(prompt))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
        return openAiService.createCompletion(completionRequest).getChoices();
    }

    private String tellMeWhyIWasIncorrect(String givenPrompt, String givenAnswer) {
        return new StringBuilder()
                .append("Gdzie miałem błąd w odpowiedzi ?:")

                .append("Pytanie: ").append(givenPrompt).append("\n")

                .append("Moja Odpowiedź brzmiała tak: ").append(givenAnswer)
                .append("\n").toString();
//                .append(givenPrompt)
//                .append("Odpowiedz tak lub nie")
//                .append(givenAnswer).toString();
    }

    public List<CompletionChoice> tellMeWhyIWasIncorrect(RequestTaskDto requestTaskDto, String mojaOdpowiedz) {
        log.error("tellMeWhyIWasIncorrect: " + requestTaskDto.getQuestion() + " " + mojaOdpowiedz);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(tellMeWhyIWasIncorrect(requestTaskDto.getQuestion(), mojaOdpowiedz))
                .maxTokens(maxTokens)
                .temperature(0.5)
                .echo(true)
                .build();
        return openAiService.createCompletion(completionRequest).getChoices();
    }

}
