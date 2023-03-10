package com.freecoders.server.repository;

import com.freecoders.server.entites.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
    Account findByEmail(String email);
    boolean existsAccountByEmail(String email);
}

