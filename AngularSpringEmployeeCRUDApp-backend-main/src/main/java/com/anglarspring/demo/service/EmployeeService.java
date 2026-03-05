package com.anglarspring.demo.service;

import com.anglarspring.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Page<Employee> getAllEmployees(Pageable pageable);
    Page<Employee> searchEmployees(String keyword, Pageable pageable);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

}
