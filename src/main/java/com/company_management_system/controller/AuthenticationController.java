package com.company_management_system.controller;

import com.company_management_system.entity.Employee;
import com.company_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/login-page")
    public String showLoginPage(){
        return "login-page";
    }

    @GetMapping("/register-page")
    public String showRegistrationForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "register-page";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("employee") Employee employee, Model model) {
        if (employeeService.isUsernameTaken(employee.getUsername())) {
            model.addAttribute("error", "Username is already taken!");
            return "login-page";
        }
        employeeService.registerUser(employee);
        return "login-page";
    }

}
