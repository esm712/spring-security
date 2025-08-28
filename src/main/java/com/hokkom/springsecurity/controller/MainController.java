package com.hokkom.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/")
    public String home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("======================================");
        System.out.println("Principal: " + auth.getPrincipal());
        System.out.println("Authorities: " + auth.getAuthorities());
        System.out.println("Credentials: " + auth.getCredentials());
        System.out.println("Authenticated: " + auth.isAuthenticated());
        System.out.println("======================================");

        return "Test Page";
    }
}
