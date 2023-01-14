package com.freecoders.server;

import com.freecoders.server.entites.Account;
import com.freecoders.server.entites.Plan;
import com.freecoders.server.entites.Role;
import com.freecoders.server.entites.Task;
import com.freecoders.server.repository.AccountRepository;
import com.freecoders.server.repository.PlanRepository;
import com.freecoders.server.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StartAndTestThingsSeed {
    private final AccountRepository accountRepository;
    private final TaskRepository taskRepository;
    private final PlanRepository planRepository;

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
            accountRepository.save(account);
        }
    }

    private void createTestPlanAndTasks() {
        if(planRepository.count() == 0) {
            Task task = new Task();
            task.setName("task1");
            task.setDescription("task desc 1");

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
