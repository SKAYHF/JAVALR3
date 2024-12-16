package com.JavaLab.online_bank.service;

import com.JavaLab.online_bank.entity.CreditAccount;
import com.JavaLab.online_bank.entity.PaymentAccount;
import com.JavaLab.online_bank.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    User create(User user);

    void calculateCreditRating(User user);

    boolean addCreditAccount(Long id, CreditAccount account);

    boolean addPaymentAccount(Long id, PaymentAccount account);

    List<PaymentAccount> getAllPaymentAccountsByUserId(Long id);

    List<CreditAccount> getAllCreditAccountsByUserId(Long id);

    List<User> getAllUsers();

    User getUserById(Long id);

    void printUserData(Long id, boolean withAccounts);
}
