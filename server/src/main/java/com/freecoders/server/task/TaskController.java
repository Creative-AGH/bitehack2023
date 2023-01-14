package com.freecoders.server.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/task/{id}")
    public ResponseEntity<?> getSingleTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getSingleTask(id));
    }
}
