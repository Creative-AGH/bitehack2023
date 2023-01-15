package com.freecoders.server.task.dto;

import com.freecoders.server.entites.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface TaskMapper {
    TaskDto mapTaskToTaskDto(Task task);
}
