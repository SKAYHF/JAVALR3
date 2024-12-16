package com.JavaLab.online_bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class BankOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ManyToOne
    private Bank bank;

    private boolean isOperational;
    private boolean canPlaceAtm;
    private int atmCount;

    private boolean hasLoanServices;
    private boolean hasCashWithdrawal;
    private boolean hasCashDeposit;

    private BigDecimal totalMoney;
    private BigDecimal rentPrice;

    public BankOffice() {
    }

    public BankOffice(String name, String address, Bank bank, boolean isOperational, boolean canPlaceAtm,
                      boolean hasLoanServices, boolean hasCashWithdrawal, boolean hasCashDeposit,
                      BigDecimal totalMoney, BigDecimal rentPrice) {
        this.name = name;
        this.address = address;
        this.bank = bank;
        this.isOperational = isOperational;
        this.canPlaceAtm = canPlaceAtm;
        this.hasLoanServices = hasLoanServices;
        this.hasCashWithdrawal = hasCashWithdrawal;
        this.hasCashDeposit = hasCashDeposit;
        this.totalMoney = totalMoney;
        this.rentPrice = rentPrice;
        this.atmCount = 0;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public void setOperational(boolean operational) {
        isOperational = operational;
    }

    public boolean isCanPlaceAtm() {
        return canPlaceAtm;
    }

    public void setCanPlaceAtm(boolean canPlaceAtm) {
        this.canPlaceAtm = canPlaceAtm;
    }

    public int getAtmCount() {
        return atmCount;
    }

    public void setAtmCount(int atmCount) {
        this.atmCount = atmCount;
    }

    public boolean isHasLoanServices() {
        return hasLoanServices;
    }

    public void setHasLoanServices(boolean hasLoanServices) {
        this.hasLoanServices = hasLoanServices;
    }

    public boolean isHasCashWithdrawal() {
        return hasCashWithdrawal;
    }

    public void setHasCashWithdrawal(boolean hasCashWithdrawal) {
        this.hasCashWithdrawal = hasCashWithdrawal;
    }

    public boolean isHasCashDeposit() {
        return hasCashDeposit;
    }

    public void setHasCashDeposit(boolean hasCashDeposit) {
        this.hasCashDeposit = hasCashDeposit;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public boolean isAtmPlaceable() {
        return this.canPlaceAtm;
    }
}
