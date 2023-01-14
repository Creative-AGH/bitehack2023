package com.freecoders.server.avability;

import com.freecoders.server.avability.dto.AvabilityDto;
import com.freecoders.server.avability.dto.AvailabilityMapper;
import com.freecoders.server.entites.Availability;
import com.freecoders.server.repository.AvabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class AvailabilityService
{
    private final AvabilityRepository avabilityRepository;
    private final AvailabilityMapper availabilityMapper;
    
    @Transactional
    public void addNewAvaibilityForUser(AvabilityDto avabilityDto)
    {
        Availability avability = availabilityMapper.mapAvabilityDtoToAvability(avabilityDto);
        avabilityRepository.save(avability);
    }
}
