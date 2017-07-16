package com.hiczp.web.mystery.controller;

import com.hiczp.web.mystery.annotation.ActiveNavItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by czp on 17-7-15.
 */
@Controller
@RequestMapping("/pass")
public class PassController {
    @GetMapping("/security")
    @ActiveNavItem("账号安全")
    public ModelAndView security(ModelAndView modelAndView) {
        return modelAndView;
    }
}
