package com.JavaLab.online_bank.service;

import com.JavaLab.online_bank.entity.PaymentAccount;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentAccountService {

    PaymentAccount create(PaymentAccount paymentAccount);

    boolean depositMoney(Long id, BigDecimal amount);

    boolean withdrawMoney(Long id, BigDecimal amount);

    List<PaymentAccount> getAllPaymentAccounts();

    PaymentAccount getPaymentAccountById(Long id);

    List<PaymentAccount> getAllPaymentAccountsByUserId(Long userId);

    void printPaymentData(Long id);

    BigDecimal getBalance(Long id); // Убедитесь, что этот метод есть
}
