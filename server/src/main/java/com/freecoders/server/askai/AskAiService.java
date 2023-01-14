package com.freecoders.server.askai;

import com.freecoders.server.ai.comunication.AiService;
import com.theokanning.openai.completion.CompletionChoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
@Slf4j
public class AskAiService {
    private final AiService aiService;

    public void askAiIfIMCorrect(ResponseTaskDto responseTaskDto) {

        String answear = aiService.createRequestToOpenAi(responseTaskDto)
                .stream().findFirst()
                .map(CompletionChoice::getText)
                .get();
        String answerYesOrNo = answear.split(" ")[answear.split(" ").length - 1];
        System.out.println("answerYesOrNo = " + answerYesOrNo);
        answerYesOrNo= answerYesOrNo.trim();
        if(answerYesOrNo.equals("TAK")) {
            //TODO IMPLEMENT rewand mechanism
            //FIXME let it work normalny :) :)
            log.info("Yes");
        } else {
            log.info("No");
        }

       return;

    }


}
