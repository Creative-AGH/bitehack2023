package com.freecoders.server.avability.dto;

import com.freecoders.server.entites.Availability;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AvailabilityMapper.class)
public interface AvailabilityMapper {
    @Mapping(target = "fromDate", source = "fromDate")
    @Mapping(target = "toDate", source = "toDate")
    Availability mapAvailabilityDtoToAvailability(AvailabilityDto availabilityDto);
}
