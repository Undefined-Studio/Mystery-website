package com.hiczp.web.mystery.api;

import com.hiczp.web.mystery.configuration.WebSecurityConfiguration;
import com.hiczp.web.mystery.dto.DataDto;
import com.hiczp.web.mystery.dto.ResponseDto;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Created by czp on 17-7-7.
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    @PostMapping("/login")
    public ResponseDto login(String username, String password) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = WebSecurityConfiguration.getHttpSecurity().getSharedObject(AuthenticationManager.class).authenticate(usernamePasswordAuthenticationToken);
            securityContext.setAuthentication(authentication);
            return new DataDto().put("SESSION", RequestContextHolder.currentRequestAttributes().getSessionId());
        } catch (AuthenticationException e) {
            securityContext.setAuthentication(null);
            return new ResponseDto(1, e.getMessage());
        }
    }

    @GetMapping("/checkLogin")
    public DataDto testLogin() {
        return new DataDto().put("isAuthenticated", !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken));
    }
}
