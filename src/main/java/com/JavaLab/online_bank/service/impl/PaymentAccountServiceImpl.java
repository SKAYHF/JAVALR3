package com.JavaLab.online_bank.service.impl;

import com.JavaLab.online_bank.entity.PaymentAccount;
import com.JavaLab.online_bank.repository.PaymentAccountRepository;
import com.JavaLab.online_bank.service.PaymentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentAccountServiceImpl implements PaymentAccountService {

    @Autowired
    private PaymentAccountRepository paymentAccountRepository;

    @Override
    public PaymentAccount create(PaymentAccount paymentAccount) {
        if (paymentAccount == null || paymentAccount.getBalance().signum() < 0) {
            System.err.println("Error: PaymentAccount - invalid payment account");
            return null;
        }
        return paymentAccountRepository.save(paymentAccount);
    }

    @Override
    public boolean depositMoney(Long id, BigDecimal amount) {
        PaymentAccount paymentAccount = paymentAccountRepository.findById(id).orElse(null);
        if (paymentAccount == null || amount.signum() <= 0) {
            System.err.println("Error: invalid deposit");
            return false;
        }
        paymentAccount.setBalance(paymentAccount.getBalance().add(amount));
        paymentAccountRepository.save(paymentAccount);
        return true;
    }

    @Override
    public boolean withdrawMoney(Long id, BigDecimal amount) {
        PaymentAccount paymentAccount = paymentAccountRepository.findById(id).orElse(null);
        if (paymentAccount == null || amount.signum() <= 0 || paymentAccount.getBalance().compareTo(amount) < 0) {
            System.err.println("Error: invalid withdrawal");
            return false;
        }
        paymentAccount.setBalance(paymentAccount.getBalance().subtract(amount));
        paymentAccountRepository.save(paymentAccount);
        return true;
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountRepository.findAll();
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long id) {
        return paymentAccountRepository.findById(id).orElse(null);
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccountsByUserId(Long userId) {
        return paymentAccountRepository.findAllByUserId(userId);
    }

    @Override
    public void printPaymentData(Long id) {
        PaymentAccount account = getPaymentAccountById(id);
        if (account == null) {
            System.out.println("Payment account not found.");
            return;
        }
        System.out.println(account);
    }

    @Override
    public BigDecimal getBalance(Long id) {
        PaymentAccount paymentAccount = paymentAccountRepository.findById(id).orElse(null);
        if (paymentAccount == null) {
            System.err.println("Error: PaymentAccount not found");
            return BigDecimal.ZERO;
        }
        return paymentAccount.getBalance();
    }
}
