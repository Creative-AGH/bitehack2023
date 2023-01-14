package com.freecoders.server.avability.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class AvabilityDto {

    private LocalDateTime fromDate;
    private LocalDateTime toDate;
}
