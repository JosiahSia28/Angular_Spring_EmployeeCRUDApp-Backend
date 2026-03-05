package com.anglarspring.demo.controller;

import com.anglarspring.demo.entity.Employee;
import com.anglarspring.demo.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "https://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
            ){
        return employeeService.getAllEmployees(PageRequest.of(page,size));
    }

    @GetMapping("/search")
    public Page<Employee> searchEmployees(
        @RequestParam String keyword,
        Pageable pageable
    ){
        return employeeService.searchEmployees(keyword, pageable);
    }

    @PostMapping
    @Transactional
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @Transactional
    @PutMapping("/{id}")
    public Employee updateEmployee(
        @PathVariable Long id,
        @RequestBody Employee employee
    ){
        return employeeService.updateEmployee(id,employee);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
