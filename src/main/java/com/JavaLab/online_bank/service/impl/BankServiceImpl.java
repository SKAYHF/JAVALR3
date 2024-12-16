package com.JavaLab.online_bank.service.impl;

import com.JavaLab.online_bank.entity.Bank;
import com.JavaLab.online_bank.entity.BankOffice;
import com.JavaLab.online_bank.repository.BankRepository;
import com.JavaLab.online_bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank create(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public void updateAtmCount(Long bankId, int atmCount) {
        Bank bank = bankRepository.findById(bankId).orElse(null);
        if (bank != null) {
            bank.setAtmCount(atmCount);
            bankRepository.save(bank);
        }
    }

    @Override
    public int getAtmCount(Long bankId) {
        Bank bank = bankRepository.findById(bankId).orElse(null);
        if (bank != null) {
            return bank.getAtmCount();
        }
        return 0;
    }
}
