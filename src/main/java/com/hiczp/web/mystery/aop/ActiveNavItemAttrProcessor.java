package com.hiczp.web.mystery.aop;

import com.hiczp.web.mystery.annotation.ActiveNavItem;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by czp on 17-7-5.
 */
@Aspect
@Configuration
public class ActiveNavItemAttrProcessor {
    @Before(value = "execution(org.springframework.web.servlet.ModelAndView com.hiczp.web.mystery.controller.*.*(..)) && @annotation(activeNavItem) && args(modelAndView,..)")
    public void addActiveNavItemAttr(ActiveNavItem activeNavItem, ModelAndView modelAndView) {
        if (modelAndView.getView() instanceof RedirectView) {
            return;
        }
        modelAndView.addObject("activeNavItem", activeNavItem.value());
    }
}
