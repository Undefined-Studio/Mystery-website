package com.hiczp.web.mystery.api;

import com.hiczp.web.mystery.entity.Account;
import com.hiczp.web.mystery.repository.AccountRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

/**
 * Created by czp on 17-7-7.
 */
@RestController
@RequestMapping("/api/user")
public class UserAPIController {
    private AccountRepository accountRepository;
    private EntityManager entityManager;

    public UserAPIController(AccountRepository accountRepository, EntityManager entityManager) {
        this.accountRepository = accountRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("/myInfo")
    public Account myInfo() {
        return accountRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
