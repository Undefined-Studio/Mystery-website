package com.hiczp.web.mystery.aop;

import com.hiczp.web.mystery.repository.AccountRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by czp on 17-7-16.
 */
@Aspect
@Configuration
public class PassAOPConfiguration {
    private AccountRepository accountRepository;

    public PassAOPConfiguration(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @AfterReturning(value = "execution(org.springframework.web.servlet.ModelAndView com.hiczp.web.mystery.controller.PassController.*(..))", returning = "modelAndView")
    public void afterPassReturning(ModelAndView modelAndView) {
        if (modelAndView.getView() instanceof RedirectView || modelAndView.getModel().get("account") != null) {
            return;
        }
        modelAndView.addObject("account", accountRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
    }
}
