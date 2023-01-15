package com.freecoders.server.askai;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AskAiController {
    private final AskAiService askAiService;

    @PostMapping("/askai")
    public ResponseEntity<?> askAi(@RequestBody RequestTaskDto requestTaskDto) {
        System.out.println("askAi: " + requestTaskDto);
        return ResponseEntity.ok(askAiService.askAiIfIMCorrect(requestTaskDto));

    }

}
