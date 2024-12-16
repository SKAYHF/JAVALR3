package com.JavaLab.online_bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int atmCount;
    private int officeCount;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
        this.atmCount = 0;
        this.officeCount = 0;
    }

    // Геттеры и сеттеры для поля id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Геттеры и сеттеры для поля name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры для поля atmCount
    public int getAtmCount() {
        return atmCount;
    }

    public void setAtmCount(int atmCount) {
        this.atmCount = atmCount;
    }

    // Геттеры и сеттеры для поля officeCount
    public int getOfficeCount() {
        return officeCount;
    }

    public void setOfficeCount(int officeCount) {
        this.officeCount = officeCount;
    }
}
