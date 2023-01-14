package com.freecoders.server.plan.dto;

import com.freecoders.server.entites.Plan;
import com.freecoders.server.entites.Task;
import com.freecoders.server.task.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = PlanMapper.class)
public interface PlanMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "tasksDto", source = "tasks")
    PlanDto mapPlanToPlanDto(Plan plan);

    default List<TaskDto> mapTasksToTasksDto(List<Task> tasks) {
        List<TaskDto> taskDtos = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            TaskDto taskDto = new TaskDto();
            taskDto.setId(tasks.get(i).getId());
            taskDto.setName(tasks.get(i).getName());
            taskDto.setDescription(tasks.get(i).getDescription());
            taskDto.setTaskDateTime(tasks.get(i).getTaskDateTime());
            taskDto.setPromptContext(tasks.get(i).getPromptContext());
            taskDto.setQuestion(tasks.get(i).getQuestion());
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }


}
