package com.freecoders.server.plan;

import com.freecoders.server.plan.dto.PlanDto;
import com.freecoders.server.plan.dto.PlanMapper;
import com.freecoders.server.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    public PlanDto getPlanById(Long planId) {
        return planMapper.mapPlanToPlanDto(
                planRepository.findById(planId)
                        .orElseThrow(() -> new IllegalStateException("There is no such plan with id=" + planId)));
    }

    public List<PlanDto> getAllPlans() {
        return planRepository.findAll().stream()
                .map(planMapper::mapPlanToPlanDto)
                .toList();
    }
}
