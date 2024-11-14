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

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/add")
    public String showAddNewEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "add-employee-form";
    }

    @PostMapping("/save")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/table";
    }

}
