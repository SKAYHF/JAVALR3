package com.JavaLab.online_bank.service.impl;

import com.JavaLab.online_bank.entity.BankAtm;
import com.JavaLab.online_bank.repository.AtmRepository;
import com.JavaLab.online_bank.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private final AtmRepository atmRepository;

    @Autowired
    public AtmServiceImpl(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    public List<BankAtm> getAllAtms() {
        return atmRepository.findAll();
    }

    @Override
    public BankAtm getAtmById(Long id) {
        return atmRepository.findById(id).orElse(null);
    }

    @Override
    public BankAtm create(BankAtm atm) {
        return atmRepository.save(atm);
    }

    @Override
    public void deleteAtmById(Long id) {
        atmRepository.deleteById(id);
    }

    @Override
    public boolean isCashDepositAvailable(Long id) {
        BankAtm atm = getAtmById(id);
        return atm != null && atm.isCashDepositAvailable();
    }

    @Override
    public boolean isCashWithdrawalAvailable(Long id) {
        BankAtm atm = getAtmById(id);
        return atm != null && atm.isCashWithdrawalAvailable();
    }

    @Override
    public BigDecimal getBalance(Long id) {
        BankAtm atm = getAtmById(id);
        return atm != null ? atm.getBalance() : BigDecimal.ZERO;
    }

    @Override
    public void updateBalance(Long id, BigDecimal newBalance) {
        BankAtm atm = getAtmById(id);
        if (atm != null) {
            atm.setBalance(newBalance);
            atmRepository.save(atm);
        }
    }
}
