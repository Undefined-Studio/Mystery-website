package com.hiczp.web.mystery.repository;

import com.hiczp.web.mystery.entity.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by czp on 17-7-4.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
}
