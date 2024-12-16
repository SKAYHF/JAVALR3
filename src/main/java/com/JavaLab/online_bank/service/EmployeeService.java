package com.JavaLab.online_bank.service;

import com.JavaLab.online_bank.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee create(Employee employee);

    boolean assignToOffice(Long employeeId, Long officeId);

    boolean fireEmployee(Long employeeId);
}
