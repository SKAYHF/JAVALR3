package com.JavaLab.online_bank.service.impl;

import com.JavaLab.online_bank.entity.BankOffice;
import com.JavaLab.online_bank.entity.Employee;
import com.JavaLab.online_bank.repository.BankOfficeRepository;
import com.JavaLab.online_bank.repository.EmployeeRepository;
import com.JavaLab.online_bank.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BankOfficeRepository bankOfficeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean assignToOffice(Long employeeId, Long officeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        BankOffice office = bankOfficeRepository.findById(officeId).orElse(null);

        if (employee == null || office == null) {
            return false;
        }

        employee.setOffice(office);
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean fireEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }
}
