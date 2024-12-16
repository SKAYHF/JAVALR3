package com.JavaLab.online_bank;

import com.JavaLab.online_bank.entity.*;
import com.JavaLab.online_bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class OnlineBankApplication implements CommandLineRunner {

	@Autowired
	private BankService bankService;

	@Autowired
	private BankOfficeService bankOfficeService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AtmService atmService;

	@Autowired
	private UserService userService;

	@Autowired
	private PaymentAccountService paymentAccountService;

	@Autowired
	private CreditAccountService creditAccountService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Random random = new Random();

		// Создаём банки
		bankService.create(new Bank("Iron Bank of Braavos"));
		bankService.create(new Bank("Bank of Casterly Rock"));

		// Создаём офисы
		List<Bank> banks = bankService.getAllBanks();
		for (Bank bank : banks) {
			bankOfficeService.create(new BankOffice(
					"Office 1 " + bank.getName(),
					"Some address",
					bank,
					true,
					true,
					true,
					true,
					true,
					new BigDecimal("10000"),
					new BigDecimal("5000")
			));
		}

		// Добавляем сотрудников
		List<BankOffice> offices = bankOfficeService.getAllOffices();
		for (BankOffice office : offices) {
			employeeService.create(new Employee(
					"Employee Name",
					LocalDate.now(),
					Employee.Job.MANAGER,
					office.getBank(),
					office,
					new BigDecimal("3000")
			));
		}

		// Добавляем банкоматы
		for (BankOffice office : offices) {
			atmService.create(new BankAtm(
					"ATM 1",                 // name
					office.getAddress(),           // address
					true,                          // isOperational
					true,                          // supportsWithdrawals
					true,                          // supportsDeposits
					BigDecimal.ZERO,               // balance
					office                         // связываем с BankOffice
			));
		}

		System.out.println("Setup Complete.");
	}
}
