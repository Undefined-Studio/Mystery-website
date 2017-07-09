package com.hiczp.web.mystery.api;

import com.hiczp.web.mystery.dto.DataDto;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by czp on 17-7-7.
 */
@RestController
@RequestMapping("/api")
public class LoginController {
////    private HttpSecurityBuilder httpSecurityBuilder;
////
////    public LoginController(HttpSecurityBuilder httpSecurityBuilder) {
////        this.httpSecurityBuilder = httpSecurityBuilder;
////    }
//
//    @PostMapping("/login")
//    public DataDto login(String username, String password) {
////        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
////        Authentication authentication = httpSecurityBuilder.getOrBuild().authenticate(usernamePasswordAuthenticationToken);
////        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        return new DataDto().put("SESSION", RequestContextHolder.currentRequestAttributes().getSessionId());
//    }

    @GetMapping("/checkLogin")
    public DataDto testLogin() {
        return new DataDto().put("isAuthenticated", !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken));
    }
}
