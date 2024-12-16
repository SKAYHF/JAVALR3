package com.JavaLab.online_bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class BankAtm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private boolean isOperational;
    private boolean supportsWithdrawals;
    private boolean supportsDeposits;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "office_id") // Добавляем связь с BankOffice
    private BankOffice office;

    public BankAtm() {
        this.balance = BigDecimal.ZERO;
    }

    public BankAtm(String name, String address, boolean isOperational, boolean supportsWithdrawals, boolean supportsDeposits, BigDecimal balance, BankOffice office) {
        this.name = name;
        this.address = address;
        this.isOperational = isOperational;
        this.supportsWithdrawals = supportsWithdrawals;
        this.supportsDeposits = supportsDeposits;
        this.balance = balance != null ? balance : BigDecimal.ZERO;
        this.office = office;
    }

    public BankOffice getOffice() {
        return office;
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    // Новый метод: Проверка доступности депозита
    public boolean isCashDepositAvailable() {
        return supportsDeposits && isOperational;
    }

    // Новый метод: Проверка доступности снятия наличных
    public boolean isCashWithdrawalAvailable() {
        return supportsWithdrawals && isOperational;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public boolean isOperational() { return isOperational; }
    public void setOperational(boolean operational) { isOperational = operational; }

    public boolean isSupportsWithdrawals() { return supportsWithdrawals; }
    public void setSupportsWithdrawals(boolean supportsWithdrawals) { this.supportsWithdrawals = supportsWithdrawals; }

    public boolean isSupportsDeposits() { return supportsDeposits; }
    public void setSupportsDeposits(boolean supportsDeposits) { this.supportsDeposits = supportsDeposits; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
