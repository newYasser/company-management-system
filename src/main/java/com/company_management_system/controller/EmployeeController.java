package com.company_management_system.controller;

import com.company_management_system.entity.Employee;
import com.company_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/table")
    public String getAllEmployee(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employees-table";
    }
}
