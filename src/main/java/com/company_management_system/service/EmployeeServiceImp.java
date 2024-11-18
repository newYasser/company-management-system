package com.company_management_system.service;

import com.company_management_system.entity.Employee;
import com.company_management_system.entity.Role;
import com.company_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id){
        return employeeRepository.getReferenceById(id);
    }

    @Override
    public void deleteEmployeeById(Long id){employeeRepository.deleteById(id);}


    @Override
    public Employee registerUser(Employee employee) {
        employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
        employee.setEnabled(true);
        return employeeRepository.save(employee);
    }
    @Override
    public boolean isUsernameTaken(String username) {
        return employeeRepository.findByUsername(username).isPresent();
    }

    @Override
    public Employee getEmployeeByUsername(String username) {

        return employeeRepository.findByUsername(username).orElseThrow();
    }

}
