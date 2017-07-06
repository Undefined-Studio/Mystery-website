package com.hiczp.web.mystery.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by czp on 17-7-6.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/avatar/user/**")
                .addResourceLocations("file:./resources/image/avatar/user/")
                .setCachePeriod(0);   //用户头像不缓存

        registry.addResourceHandler("/image/book/**")
                .addResourceLocations("file:./resources/image/book/");
    }
}
