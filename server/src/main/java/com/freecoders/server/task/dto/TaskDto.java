package com.freecoders.server.task.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String description;
}
