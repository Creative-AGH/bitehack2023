package com.freecoders.server.security;

import com.freecoders.server.entites.Account;
import com.freecoders.server.entites.Role;
import com.freecoders.server.security.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("USER {} tries to atempt authenticate ",username);
        Optional<Account> userOptional = loginService.findByEmailTeam(username);
        if (userOptional.isPresent()) {


            Account user = userOptional.get();
            String[] roles;
            roles = Optional.of(user.getRole()).stream().map(Role::toString).toArray(String[]::new);
            return User
                    .builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(roles)
                    .build();

        } else {
            throw new UsernameNotFoundException(String.format("Username {} not found",username));
        }


    }
}
