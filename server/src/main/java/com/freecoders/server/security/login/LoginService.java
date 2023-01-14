package com.freecoders.server.security.login;


import com.freecoders.server.entites.Account;
import com.freecoders.server.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AccountRepository accountRepository;

    public Optional<Account> findByEmailTeam(String username) {
        Optional<Account> optionalRegisterTeam = Optional.ofNullable(accountRepository.findByEmail(username));
        return optionalRegisterTeam;

    }


}
