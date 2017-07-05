package com.hiczp.web.mystery.aop;

import com.hiczp.web.mystery.annotation.BreadCrumbs;
import com.hiczp.web.mystery.model.BreadCrumb;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czp on 17-7-5.
 */
@Aspect
@Configuration
public class BreadCrumbsGenerator {
    @Around("execution(org.springframework.web.servlet.ModelAndView com.hiczp.web.mystery.controller.*.*(..)) && @annotation(com.hiczp.web.mystery.annotation.BreadCrumbs)")
    public Object generateBreadCrumb(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ModelAndView modelAndView = (ModelAndView) proceedingJoinPoint.proceed();
        if (modelAndView.getView() instanceof RedirectView) {
            return modelAndView;
        }
        BreadCrumbs breadCrumbsAnnotationOnClass = proceedingJoinPoint.getTarget().getClass().getAnnotation(BreadCrumbs.class);
        BreadCrumbs breadCrumbsAnnotationOnMethod = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getAnnotation(BreadCrumbs.class);
        String[] names = ArrayUtils.addAll(breadCrumbsAnnotationOnClass.names(), breadCrumbsAnnotationOnMethod.names());
        String[] links = ArrayUtils.addAll(breadCrumbsAnnotationOnClass.links(), breadCrumbsAnnotationOnMethod.links());
        List<BreadCrumb> breadCrumbs = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            String link = i >= links.length ? null : links[i];
            breadCrumbs.add(new BreadCrumb(names[i], link));
        }
        return modelAndView.addObject("breadCrumbs", breadCrumbs);
    }
}
