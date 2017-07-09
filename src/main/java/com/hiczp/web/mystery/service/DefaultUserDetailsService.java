package com.hiczp.web.mystery.service;

import com.hiczp.web.mystery.entity.Account;
import com.hiczp.web.mystery.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by czp on 17-7-4.
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService {
    private AccountRepository accountRepository;

    public DefaultUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(String.format("Username '%s' not found", username));
        }
        return new User(account.getUsername(), account.getPassword(), Arrays.asList(() -> "ROLE_USER"));
    }
}
