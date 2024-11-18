package com.company_management_system.controller;

import com.company_management_system.entity.Employee;
import com.company_management_system.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeService;
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

    @GetMapping("/edit")
    public String editEmployee(@RequestParam("id") Long id, Model model){

        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "edit-employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/table";
    }



}
