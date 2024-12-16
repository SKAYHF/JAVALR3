package com.JavaLab.online_bank.service;

import com.JavaLab.online_bank.entity.BankAtm;

import java.math.BigDecimal;
import java.util.List;

public interface AtmService {

    List<BankAtm> getAllAtms();

    BankAtm getAtmById(Long id);

    BankAtm create(BankAtm atm);

    void deleteAtmById(Long id);

    boolean isCashDepositAvailable(Long id);

    boolean isCashWithdrawalAvailable(Long id);

    BigDecimal getBalance(Long id);

    void updateBalance(Long id, BigDecimal newBalance);
}
