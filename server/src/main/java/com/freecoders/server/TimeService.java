package com.freecoders.server;

import com.freecoders.server.entites.Availability;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeService {
    public static List<LocalDateTime> divideTasks(List<Availability> availabilities, int numTasks) {
        List<LocalDateTime> startTimes = new ArrayList<>();
        for (Availability availability : availabilities) {
            startTimes.add(availability.getFromDate());
        }
        if (startTimes.size() >= numTasks) {
            return startTimes.subList(0, numTasks);
        } else {
            int index = 0;
            List<LocalDateTime> dividedTasks = new ArrayList<>();
            for (int i = 0; i < numTasks; i++) {
                dividedTasks.add(startTimes.get(index));
                index = (index + 1) % startTimes.size();
            }
            return dividedTasks;
        }
    }

    public static boolean checkForOverlappingTasks(List<LocalDateTime> tasks) {
        Map<LocalDateTime, Integer> taskCount = new HashMap<>();
        for (LocalDateTime task : tasks) {
            if (!taskCount.containsKey(task)) {
                taskCount.put(task, 1);
            } else {
                taskCount.put(task, taskCount.get(task) + 1);
            }
        }
        for (LocalDateTime task : tasks) {
            if (taskCount.get(task) > 1) {
                return true;
            }
        }
        return false;
    }

    public static List<LocalDateTime> divideTasksWithUniqueStartTimes(List<Availability> availabilities, int numTasks) {
        List<LocalDateTime> tasks = divideTasks(availabilities, numTasks);
        while (checkForOverlappingTasks(tasks)) {
            tasks = divideTasks(availabilities, numTasks);
        }
        return tasks;
    }
}
