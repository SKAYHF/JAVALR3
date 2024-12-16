package com.JavaLab.online_bank.service.impl;

import com.JavaLab.online_bank.entity.CreditAccount;
import com.JavaLab.online_bank.entity.PaymentAccount;
import com.JavaLab.online_bank.entity.User;
import com.JavaLab.online_bank.repository.CreditAccountRepository;
import com.JavaLab.online_bank.repository.PaymentAccountRepository;
import com.JavaLab.online_bank.repository.UserRepository;
import com.JavaLab.online_bank.service.UserService;
import com.JavaLab.online_bank.utils.BigRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CreditAccountRepository creditAccountRepository;
    private final PaymentAccountRepository paymentAccountRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CreditAccountRepository creditAccountRepository, PaymentAccountRepository paymentAccountRepository) {
        this.userRepository = userRepository;
        this.creditAccountRepository = creditAccountRepository;
        this.paymentAccountRepository = paymentAccountRepository;
    }

    @Override
    public User create(User user) {
        if (user == null) {
            return null;
        }

        if (user.getBank() == null) {
            System.err.println("Error: User - must have bank");
            return null;
        }

        final BigDecimal monthlyIncome = BigRandom.between(BigDecimal.ZERO, User.MAX_MONTHLY_INCOME);
        user.setMonthlyIncome(monthlyIncome);
        calculateCreditRating(user);

        return userRepository.save(user);
    }

    @Override
    public void calculateCreditRating(User user) {
        if (user == null || user.getMonthlyIncome() == null) {
            System.err.println("Error: User - invalid monthly income");
            return;
        }

        user.setCreditRating(
                user.getMonthlyIncome()
                        .divide(new BigDecimal("1000"), RoundingMode.HALF_UP)
                        .multiply(new BigDecimal("100"))
        );
        userRepository.save(user);
    }

    @Override
    public boolean addCreditAccount(Long id, CreditAccount account) {
        User user = getUserById(id);
        if (user != null) {
            account.setUser(user);
            creditAccountRepository.save(account);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPaymentAccount(Long id, PaymentAccount account) {
        User user = getUserById(id);
        if (user != null) {
            account.setUser(user);
            paymentAccountRepository.save(account);
            return true;
        }
        return false;
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccountsByUserId(Long id) {
        return paymentAccountRepository.findAllPaymentAccountsByUserId(id);
    }

    @Override
    public List<CreditAccount> getAllCreditAccountsByUserId(Long id) {
        return creditAccountRepository.findAllByUserId(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void printUserData(Long id, boolean withAccounts) {
        User user = getUserById(id);

        if (user == null) {
            System.err.println("User with id " + id + " not found");
            return;
        }

        System.out.println(user);

        if (withAccounts) {
            List<PaymentAccount> paymentAccounts = getAllPaymentAccountsByUserId(id);
            if (paymentAccounts != null && !paymentAccounts.isEmpty()) {
                System.out.println("Payment accounts:");
                paymentAccounts.forEach(System.out::println);
            }

            List<CreditAccount> creditAccounts = getAllCreditAccountsByUserId(id);
            if (creditAccounts != null && !creditAccounts.isEmpty()) {
                System.out.println("Credit accounts:");
                creditAccounts.forEach(System.out::println);
            }
        }
    }
}
