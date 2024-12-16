package com.JavaLab.online_bank.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "users") // Избегаем конфликта с зарезервированным словом 'user'
public class User extends Person {

    public static final BigDecimal MAX_MONTHLY_INCOME = new BigDecimal("10000");

    private String placeOfWork;
    private BigDecimal monthlyIncome;

    @ManyToOne
    @JoinColumn(name = "bank_id") // Явное имя колонки для внешнего ключа
    private Bank bank;

    private BigDecimal creditRating;

    public User() {
        super("No name", LocalDate.now());
        this.placeOfWork = "No place of work";
        this.monthlyIncome = BigDecimal.ZERO;
        this.creditRating = BigDecimal.ZERO;
    }

    public User(String name, LocalDate birthDate, String placeOfWork, BigDecimal monthlyIncome, Bank bank,
                BigDecimal creditRating) {
        super(name, birthDate);
        this.placeOfWork = placeOfWork;
        this.monthlyIncome = monthlyIncome;
        this.bank = bank;
        this.creditRating = creditRating;
    }

    // Getters and Setters
    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BigDecimal getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(BigDecimal creditRating) {
        this.creditRating = creditRating;
    }
}
