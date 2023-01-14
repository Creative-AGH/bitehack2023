package com.freecoders.server.plan.dto;

import com.freecoders.server.entites.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PlanMapper.class)
public interface PlanMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "tasksDto", source = "tasks")
    PlanDto mapPlanToPlanDto(Plan plan);

}
