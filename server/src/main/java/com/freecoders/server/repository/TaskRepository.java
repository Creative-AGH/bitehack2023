package com.freecoders.server.repository;

import com.freecoders.server.entites.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Plan, Long> {
}
