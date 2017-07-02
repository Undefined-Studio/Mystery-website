package com.hiczp.web.mystery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * Created by czp on 17-7-1.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/home/index");
        //TODO 获得前八个图册
        return modelAndView.addObject("books", Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("/home/register");
        return modelAndView;
    }
}
