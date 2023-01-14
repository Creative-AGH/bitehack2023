package com.freecoders.server.plan;

import com.freecoders.server.entites.Plan;
import com.freecoders.server.plan.dto.PlanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @GetMapping("/plan/getAllPlans")
    public ResponseEntity<List<PlanDto>> getAllPlans() {
        return ResponseEntity.ok().body(planService.getAllPlans());
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<PlanDto> getPlanById(@RequestParam Long planId) {
        return ResponseEntity.ok().body(planService.getPlanById(planId));
    }

}
