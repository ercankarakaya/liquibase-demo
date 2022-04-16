package com.ercan.controller;

import com.ercan.repository.EmployeeRepository;
import com.ercan.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/save")
    public String create(@RequestParam String name) {
        Employee employee = new Employee(name, 21);
        employeeRepository.save(employee);
        return employeeRepository.findByName(employee.getName()) + " saved.";
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

}
