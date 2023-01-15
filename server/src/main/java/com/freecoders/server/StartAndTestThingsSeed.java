package com.freecoders.server;

import com.freecoders.server.entites.*;
import com.freecoders.server.repository.AccountRepository;
import com.freecoders.server.repository.AvailabilityRepository;
import com.freecoders.server.repository.PlanRepository;
import com.freecoders.server.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StartAndTestThingsSeed {
    private final AccountRepository accountRepository;
    private final TaskRepository taskRepository;
    private final PlanRepository planRepository;
    private final AvailabilityRepository availabilityRepository;

    public void fillDatabase() {
        createTestAccount();
        createTestPlanAndTasks();
    }

    private void createTestAccount() {
        if(accountRepository.count() == 0) {
            Account account = new Account();
            account.setRole(Role.ADMIN);
            account.setPassword("admin");
            account.setEmail("amin@gmail.com");

            Availability availability1 = new Availability();
            availability1.setFromDate(LocalDateTime.now().plusDays(1));
            availability1.setToDate(LocalDateTime.now().plusDays(3));

            Availability availability2 = new Availability();
            availability2.setFromDate(LocalDateTime.now().plusDays(5));
            availability2.setToDate(LocalDateTime.now().plusDays(7));

            List<Availability> availabilities = new ArrayList<>();
            availabilities.add(availability1);
            availabilities.add(availability2);

            account.setAvailabilities(availabilities);
            availabilityRepository.save(availability1);
            availabilityRepository.save(availability2);
            accountRepository.save(account);
        }
    }

    private void createTestPlanAndTasks() {
        if(planRepository.count() == 0) {
            Task task = new Task();
            Plan plan = new Plan();
            plan.setName("plan1");
            plan.setDescription("plan desc 1");
            List<Task> tasks = new ArrayList<>();
            tasks.add(task);
            plan.setTasks(tasks);
            taskRepository.save(task);
            planRepository.save(plan);
        }
    }


}
