package com.freecoders.server.task;

import com.freecoders.server.entites.Task;
import com.freecoders.server.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task getSingleTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }


}
