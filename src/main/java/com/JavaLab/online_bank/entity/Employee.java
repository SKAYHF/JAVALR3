package com.JavaLab.online_bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Job job;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private BankOffice office;

    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String name, LocalDate hireDate, Job job, Bank bank, BankOffice office, BigDecimal salary) {
        this.name = name;
        this.hireDate = hireDate;
        this.job = job;
        this.bank = bank;
        this.office = office;
        this.salary = salary;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getOffice() {
        return office;
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    // Enum for Job
    public enum Job {
        MANAGER,
        TELLER,
        SECURITY
    }
}
