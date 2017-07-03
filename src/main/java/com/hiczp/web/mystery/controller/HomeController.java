package com.hiczp.web.mystery.controller;

import com.hiczp.web.mystery.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by czp on 17-7-1.
 */
@Controller
public class HomeController {
    private BookRepository bookRepository;

    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/home/index");
        return modelAndView.addObject("books", bookRepository.findTop8ByOrderBySortDesc());
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("/home/register");
        return modelAndView;
    }
}
