package com.hiczp.web.mystery.controller;

import com.hiczp.web.mystery.annotation.ActiveNavItem;
import com.hiczp.web.mystery.annotation.BreadCrumbs;
import com.hiczp.web.mystery.repository.CouponInstanceRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by czp on 17-7-13.
 */
@Controller
@RequestMapping("/user/coupon")
@BreadCrumbs(names = {"首页", "代金券"}, links = {"/"})
public class CouponController {
    private CouponInstanceRepository couponInstanceRepository;

    public CouponController(CouponInstanceRepository couponInstanceRepository) {
        this.couponInstanceRepository = couponInstanceRepository;
    }

    @GetMapping("/list")
    @BreadCrumbs(names = {"我的代金券"})
    @ActiveNavItem("代金券")
    public ModelAndView couponList(ModelAndView modelAndView) {
        return modelAndView.addObject("couponInstances", couponInstanceRepository.findByAccount_Username(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @GetMapping("/help")
    @BreadCrumbs(names = {"常见问题"})
    @ActiveNavItem("代金券")
    public ModelAndView couponHelp(ModelAndView modelAndView) {
        return modelAndView;
    }
}
