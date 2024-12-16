package com.JavaLab.online_bank.service;

import com.JavaLab.online_bank.entity.Bank;

import java.util.List;

public interface BankService {

    List<Bank> getAllBanks();

    Bank create(Bank bank);

    void updateAtmCount(Long bankId, int atmCount);

    int getAtmCount(Long bankId);
}
