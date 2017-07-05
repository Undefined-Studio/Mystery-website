package com.hiczp.web.mystery.controller;

import com.hiczp.web.mystery.annotation.BreadCrumbs;
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
    @GetMapping("/center")
    @BreadCrumbs(names = {"用户中心"})
    public ModelAndView center(ModelAndView modelAndView) {
        return modelAndView.addObject("activeNavItem", "我的个人中心");
    }
}
