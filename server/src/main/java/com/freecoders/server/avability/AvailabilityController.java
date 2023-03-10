package com.freecoders.server.avability;

import com.freecoders.server.avability.dto.AvailabilityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    @PostMapping("/addNewAvailability")
    private void addNewAvabilityForUser(@RequestBody AvailabilityDto availability)
    {
        availabilityService.addNewAvaibilityForUser(availability);
    }

}
