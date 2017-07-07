package com.hiczp.web.mystery.api;

import com.hiczp.web.mystery.entity.Account;
import com.hiczp.web.mystery.model.MysteryUser;
import com.hiczp.web.mystery.repository.AccountRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by czp on 17-7-7.
 */
@RestController
@RequestMapping("/api/user")
public class UserAPIController {
    private AccountRepository accountRepository;

    public UserAPIController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/myInfo")
    public Account myInfo() {
        //为了防止 SecurityContext 中的 Account 信息过时, 此处再查一次数据库
        long id = ((MysteryUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAccount().getId();
        Account account = accountRepository.findOne(id);
        account.setPassword(null);
        return account;
    }
}
