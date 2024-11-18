package com.company_management_system.controller;

import com.company_management_system.entity.Employee;
import com.company_management_system.repository.EmployeeRepository;
import com.company_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String home(Model model, Principal principal){
        Employee employee = employeeService.getEmployeeByUsername(principal.getName());
        model.addAttribute("employee", employee);
        return "home";
    }

    @GetMapping("access-denied")
    public String accessDenied(){
        return "access-denied";
    }
}
