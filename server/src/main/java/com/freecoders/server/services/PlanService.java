package com.freecoders.server.services;

import com.freecoders.server.entites.Plan;
import com.freecoders.server.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;

    public Plan getPlanById(Long planId) {
        return planRepository.findById(planId).orElseThrow(()->new IllegalStateException("There is no such plan with id="+planId));
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }
}
