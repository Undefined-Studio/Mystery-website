package com.hiczp.web.mystery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by czp on 17-7-1.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/home/index");
        return modelAndView;
    }
}
