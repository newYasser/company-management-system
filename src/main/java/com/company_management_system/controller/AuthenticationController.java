package com.company_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login-page")
    public String showLoginPage(){
        return "login-page";
    }
}
