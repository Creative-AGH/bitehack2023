package com.freecoders.server.task.dto;

import com.freecoders.server.entites.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface TaskMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    TaskDto mapTaskToTaskDto(Task task);
}
