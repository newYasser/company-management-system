package com.company_management_system.service;

import com.company_management_system.entity.Employee;
import com.company_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.getReferenceById(id);
    }
}
