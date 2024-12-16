package com.JavaLab.online_bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // Изменено с Person на User

    @ManyToOne
    private Bank bank;

    public Account() {
    }

    // Геттеры и сеттеры для поля id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Геттеры и сеттеры для поля user
    public User getUser() { // Изменено с Person на User
        return user;
    }

    public void setUser(User user) { // Изменено с Person на User
        this.user = user;
    }

    // Геттеры и сеттеры для поля bank
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
