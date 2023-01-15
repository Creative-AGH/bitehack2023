package com.freecoders.server.askai;

import com.freecoders.server.ai.comunication.AiService;
import com.theokanning.openai.completion.CompletionChoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AskAiService {
    private final AiService aiService;

    public String askAiIfIMCorrect(RequestTaskDto requestTaskDto) {
        System.out.println(requestTaskDto);
        String myAnswer = new String(requestTaskDto.getMyAnswer());

        String answear = aiService.createRequestToOpenAi(requestTaskDto)
                .stream().findFirst()
                .map(CompletionChoice::getText)
                .get();

        System.out.println(requestTaskDto);
        String answerYesOrNo= ""+answear.toCharArray()[answear.length()-3]+answear.toCharArray()[answear.length()-2]+ answear.toCharArray()[answear.length()-1];
//        String answerYesOrNo = answear.concat();
//        String answerYesOrNo = answear.split(" ")[answear.split(" ").length - 1];
        System.out.println("answerYesOrNo = " + answerYesOrNo);
        answerYesOrNo= answerYesOrNo.trim();
        if(answerYesOrNo.equals("TAK")) {
            //TODO IMPLEMENT rewand mechanism
            //FIXME let it work normalny :) :)
            log.info("Yes");
            return "Gratulacje !!";
        } else {
            log.info("No");
            System.out.println();
            return aiService.tellMeWhyIWasIncorrect(requestTaskDto, myAnswer)
                    .stream().findFirst()
                    .map(CompletionChoice::getText)
                    .get();
        }

    }


}
