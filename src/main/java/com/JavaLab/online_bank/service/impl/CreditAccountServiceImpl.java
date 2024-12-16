package com.JavaLab.online_bank.service.impl;

import com.JavaLab.online_bank.entity.CreditAccount;
import com.JavaLab.online_bank.repository.CreditAccountRepository;
import com.JavaLab.online_bank.service.CreditAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditAccountServiceImpl implements CreditAccountService {

    @Autowired
    private CreditAccountRepository creditAccountRepository;

    @Override
    public List<CreditAccount> getAllCreditAccounts() {
        return creditAccountRepository.findAll();
    }

    @Override
    public CreditAccount create(CreditAccount creditAccount) {
        if (creditAccount == null) {
            return null;
        }
        return creditAccountRepository.save(creditAccount);
    }

    @Override
    public boolean makePayment(Long creditAccountId, BigDecimal paymentAmount) {
        CreditAccount creditAccount = creditAccountRepository.findById(creditAccountId).orElse(null);
        if (creditAccount == null || paymentAmount.signum() <= 0) {
            return false;
        }

        BigDecimal remainingDebt = creditAccount.getRemainingDebt().subtract(paymentAmount);
        creditAccount.setRemainingDebt(remainingDebt.max(BigDecimal.ZERO));
        creditAccountRepository.save(creditAccount);
        return true;
    }

    @Override
    public BigDecimal calculateTotalDebt(Long creditAccountId) {
        CreditAccount creditAccount = creditAccountRepository.findById(creditAccountId).orElse(null);
        if (creditAccount == null) {
            return BigDecimal.ZERO;
        }
        return creditAccount.getRemainingDebt();
    }
}
