package com.JavaLab.online_bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class CreditAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Bank bank;

    private BigDecimal creditLimit;
    private BigDecimal remainingDebt;

    public CreditAccount() {
        this.creditLimit = BigDecimal.ZERO;
        this.remainingDebt = BigDecimal.ZERO;
    }

    public CreditAccount(User user, Bank bank, BigDecimal creditLimit, BigDecimal remainingDebt) {
        this.user = user;
        this.bank = bank;
        this.creditLimit = creditLimit;
        this.remainingDebt = remainingDebt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getRemainingDebt() {
        return remainingDebt;
    }

    public void setRemainingDebt(BigDecimal remainingDebt) {
        this.remainingDebt = remainingDebt;
    }
}
