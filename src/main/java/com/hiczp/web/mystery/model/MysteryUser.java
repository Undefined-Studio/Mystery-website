package com.hiczp.web.mystery.model;

import com.hiczp.web.mystery.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by czp on 17-7-7.
 */
public class MysteryUser extends User {
    private Account account;

    public MysteryUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Account account) {
        super(username, password, authorities);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
