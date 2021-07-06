package com.tolulope.employeemanager.service;

import com.tolulope.employeemanager.exception.UserNotFoundException;
import com.tolulope.employeemanager.model.Employee;
import com.tolulope.employeemanager.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
