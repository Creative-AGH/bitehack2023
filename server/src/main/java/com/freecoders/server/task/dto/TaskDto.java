package com.freecoders.server.task.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class TaskDto {
    private  Long id;
    private  String name;
    private  String description;
    private  LocalDateTime taskDateTime;
    private  String promptContext;
    private  String question;
}
