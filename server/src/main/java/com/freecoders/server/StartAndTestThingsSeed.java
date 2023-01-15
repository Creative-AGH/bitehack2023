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
            availability2.setFromDate(LocalDateTime.now().plusDays(5).plusDays(2));
            availability2.setToDate(LocalDateTime.now().plusDays(7).plusDays(2));

            Availability availability3 = new Availability();
            availability3.setFromDate(LocalDateTime.now().plusDays(5).plusDays(4));
            availability3.setToDate(LocalDateTime.now().plusDays(7).plusDays(4));

            Availability availability4 = new Availability();
            availability4.setFromDate(LocalDateTime.now().plusDays(5).plusDays(6));
            availability4.setToDate(LocalDateTime.now().plusDays(7).plusDays(6));

            Availability availability5 = new Availability();
            availability5.setFromDate(LocalDateTime.now().plusDays(5).plusDays(10));
            availability5.setToDate(LocalDateTime.now().plusDays(7).plusDays(10));

            Availability availability6 = new Availability();
            availability6.setFromDate(LocalDateTime.now().plusDays(5).plusDays(12));
            availability6.setToDate(LocalDateTime.now().plusDays(7).plusDays(12));

            Availability availability7 = new Availability();
            availability7.setFromDate(LocalDateTime.now().plusDays(5).plusDays(15));
            availability7.setToDate(LocalDateTime.now().plusDays(7).plusDays(15));

            Availability availability8 = new Availability();
            availability8.setFromDate(LocalDateTime.now().plusDays(5).plusDays(19));
            availability8.setToDate(LocalDateTime.now().plusDays(7).plusDays(19));

            List<Availability> availabilities = new ArrayList<>();
            availabilities.add(availability1);
            availabilities.add(availability2);
            availabilities.add(availability3);
            availabilities.add(availability4);
            availabilities.add(availability5);
            availabilities.add(availability6);
            availabilities.add(availability7);
            availabilities.add(availability8);

            account.setAvailabilities(availabilities);
            availabilityRepository.save(availability1);
            availabilityRepository.save(availability2);
            availabilityRepository.save(availability3);
            availabilityRepository.save(availability4);
            availabilityRepository.save(availability5);
            availabilityRepository.save(availability6);
            availabilityRepository.save(availability7);
            availabilityRepository.save(availability8);
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
