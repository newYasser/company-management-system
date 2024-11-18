package com.company_management_system.service;

import com.company_management_system.entity.Employee;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee save(Employee employee);

    public Employee getEmployeeById(Long id);
    public void deleteEmployeeById(Long id);
    public Employee registerUser(Employee employee);
    public boolean isUsernameTaken(String username);
    public Employee getEmployeeByUsername(String username);


}
