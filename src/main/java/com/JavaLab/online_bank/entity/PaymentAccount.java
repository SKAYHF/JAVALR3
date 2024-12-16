package com.JavaLab.online_bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class PaymentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Bank bank;

    private BigDecimal balance;

    public PaymentAccount() {
        this.balance = BigDecimal.ZERO;
    }

    public PaymentAccount(User user, Bank bank, BigDecimal balance) {
        this.user = user;
        this.bank = bank;
        this.balance = balance != null ? balance : BigDecimal.ZERO;
    }

    // Getters and Setters
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // Deposit method
    public void deposit(BigDecimal amount) {
        if (amount.signum() > 0) {
            this.balance = this.balance.add(amount);
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    // Withdraw method
    public void withdraw(BigDecimal amount) {
        if (amount.signum() > 0 && this.balance.compareTo(amount) >= 0) {
            this.balance = this.balance.subtract(amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance or invalid amount");
        }
    }
}
