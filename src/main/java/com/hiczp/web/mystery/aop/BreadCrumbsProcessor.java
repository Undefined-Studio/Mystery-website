package com.hiczp.web.mystery.aop;

import com.hiczp.web.mystery.annotation.BreadCrumbs;
import com.hiczp.web.mystery.model.BreadCrumb;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
public class BreadCrumbsProcessor {
    @Before(value = "execution(org.springframework.web.servlet.ModelAndView com.hiczp.web.mystery.controller.*.*(..)) && @target(breadCrumbsAnnotationOnClass) && @annotation(breadCrumbsAnnotationOnMethod) && args(modelAndView,..)",
            argNames = "breadCrumbsAnnotationOnClass, breadCrumbsAnnotationOnMethod, modelAndView")
    public void generateBreadCrumb(BreadCrumbs breadCrumbsAnnotationOnClass, BreadCrumbs breadCrumbsAnnotationOnMethod, ModelAndView modelAndView) {
        if (modelAndView.getView() instanceof RedirectView || modelAndView.getModel().get("breadCrumbs") != null) {
            return;
        }
        String[] names = ArrayUtils.addAll(breadCrumbsAnnotationOnClass.names(), breadCrumbsAnnotationOnMethod.names());
        String[] links = ArrayUtils.addAll(breadCrumbsAnnotationOnClass.links(), breadCrumbsAnnotationOnMethod.links());
        List<BreadCrumb> breadCrumbs = new ArrayList<>(names.length);
        for (int i = 0; i < names.length; i++) {
            String link = i >= links.length ? null : links[i];
            breadCrumbs.add(new BreadCrumb(names[i], link));
        }
        modelAndView.addObject("breadCrumbs", breadCrumbs);
    }
}
