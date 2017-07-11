package com.hiczp.web.mystery.controller;

import com.hiczp.web.mystery.annotation.ActiveNavItem;
import com.hiczp.web.mystery.annotation.BreadCrumbs;
import com.hiczp.web.mystery.repository.AccountRepository;
import com.hiczp.web.mystery.repository.CouponInstanceRepository;
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
@BreadCrumbs(names = {"首页"}, links = {"/"})
public class UserController {
    private AccountRepository accountRepository;
    private CouponInstanceRepository couponInstanceRepository;

    public UserController(AccountRepository accountRepository, CouponInstanceRepository couponInstanceRepository) {
        this.accountRepository = accountRepository;
        this.couponInstanceRepository = couponInstanceRepository;
    }

    @GetMapping("/center")
    @BreadCrumbs(names = {"用户中心"})
    @ActiveNavItem("我的个人中心")
    public ModelAndView center(ModelAndView modelAndView) {
        return modelAndView.addObject("account", accountRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @GetMapping("/coupon/list")
    @BreadCrumbs(names = {"代金券", "我的代金券"})
    @ActiveNavItem("代金券")
    public ModelAndView couponList(ModelAndView modelAndView) {
        return modelAndView.addObject("couponInstances", couponInstanceRepository.findByAccount_Username(SecurityContextHolder.getContext().getAuthentication().getName()));
    }
}
