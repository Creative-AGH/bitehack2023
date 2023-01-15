package com.freecoders.server.avability;

import com.freecoders.server.avability.dto.AvailabilityDto;
import com.freecoders.server.avability.dto.AvailabilityMapper;
import com.freecoders.server.entites.Availability;
import com.freecoders.server.repository.AvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class AvailabilityService
{
    private final AvailabilityRepository availabilityRepository;
    private final AvailabilityMapper availabilityMapper;
    
    @Transactional
    public void addNewAvaibilityForUser(AvailabilityDto availabilityDto)
    {
        Availability avability = availabilityMapper.mapAvailabilityDtoToAvailability(availabilityDto);
        availabilityRepository.save(avability);
    }
}
