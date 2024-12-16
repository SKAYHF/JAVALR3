package com.JavaLab.online_bank.service;

import com.JavaLab.online_bank.entity.CreditAccount;

import java.math.BigDecimal;
import java.util.List;

public interface CreditAccountService {
    List<CreditAccount> getAllCreditAccounts();

    CreditAccount create(CreditAccount creditAccount);

    boolean makePayment(Long creditAccountId, BigDecimal paymentAmount);

    BigDecimal calculateTotalDebt(Long creditAccountId);
}
