package com.hiczp.web.mystery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by czp on 17-7-4.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/center")
    public ModelAndView center(ModelAndView modelAndView) {
        return modelAndView.addObject("activeNavItem", "我的个人中心");
    }
}
