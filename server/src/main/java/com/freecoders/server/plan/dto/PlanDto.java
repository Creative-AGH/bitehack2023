package com.freecoders.server.plan.dto;

import com.freecoders.server.task.dto.TaskDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class PlanDto {
    private Long id;
    private String name;
    private String description;
    private List<TaskDto> tasksDto;
}
