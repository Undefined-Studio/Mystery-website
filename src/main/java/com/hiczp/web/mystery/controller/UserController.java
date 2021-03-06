package com.hiczp.web.mystery.controller;

import com.hiczp.web.mystery.annotation.ActiveNavItem;
import com.hiczp.web.mystery.annotation.BreadCrumbs;
import com.hiczp.web.mystery.repository.AccountRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by czp on 17-7-4.
 */
@Controller
@RequestMapping("/user")
@BreadCrumbs(names = "首页", links = "/")
public class UserController {
    private AccountRepository accountRepository;

    public UserController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/center")
    @BreadCrumbs(names = "用户中心")
    @ActiveNavItem("我的个人中心")
    public ModelAndView center(ModelAndView modelAndView) {
        return modelAndView.addObject("account", accountRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
    }
}
