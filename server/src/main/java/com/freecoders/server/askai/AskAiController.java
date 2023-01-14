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
    public ResponseEntity<?> askAi(@RequestBody ResponseTaskDto responseTaskDto) {
        askAiService.askAiIfIMCorrect(responseTaskDto);

        return ResponseEntity.ok("Hello");
    }

}
