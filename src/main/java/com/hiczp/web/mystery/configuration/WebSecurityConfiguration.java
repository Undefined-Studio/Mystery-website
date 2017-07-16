package com.hiczp.web.mystery.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by czp on 17-7-4.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static HttpSecurity httpSecurity;   //把 HttpSecurity 存下来, 以取得其中的 sharedObject
    private UserDetailsService userDetailsService;

    public WebSecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public static HttpSecurity getHttpSecurity() {
        return httpSecurity;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        httpSecurity = http;

        http.csrf().disable();

        //rest
        http.authorizeRequests().antMatchers("/api/user/**").fullyAuthenticated()
                .and().httpBasic();

        //page
        http.authorizeRequests().antMatchers("/user/**").authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/")
                .and().rememberMe()
                .and().logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
