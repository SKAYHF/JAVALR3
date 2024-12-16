package com.JavaLab.online_bank;

import com.JavaLab.online_bank.entity.*;
import com.JavaLab.online_bank.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OnlineBankApplicationTests {

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

	@Test
	void contextLoads() {
		// Проверяем, что контекст Spring загружается
		System.out.println("Контекст приложения успешно загружен!");
	}

	@Test
	void testCreateBank() {
		Bank bank = new Bank("Test Bank");
		bankService.create(bank);

		assertThat(bankService.getAllBanks())
				.isNotEmpty()
				.anyMatch(b -> b.getName().equals("Test Bank"));
		System.out.println("Тест создания банка успешно выполнен!");
	}

	@Test
	void testCreateBankOffice() {
		Bank bank = new Bank("Office Bank");
		bankService.create(bank);

		BankOffice office = new BankOffice(
				"Main Office",
				"123 Main St",
				bank,
				true, true, true, true, true,
				new BigDecimal("10000"),
				new BigDecimal("5000")
		);
		bankOfficeService.create(office);

		assertThat(bankOfficeService.getAllOffices())
				.isNotEmpty()
				.anyMatch(o -> o.getName().equals("Main Office"));
		System.out.println("Тест создания банковского офиса успешно выполнен!");
	}

	@Test
	void testCreateEmployee() {
		Bank bank = new Bank("Employee Bank");
		bankService.create(bank);

		BankOffice office = new BankOffice("Employee Office", "456 Street", bank, true, true, true, true, true, BigDecimal.TEN, BigDecimal.TEN);
		bankOfficeService.create(office);

		Employee employee = new Employee(
				"John Doe",
				LocalDate.now(),
				Employee.Job.MANAGER,
				bank,
				office,
				new BigDecimal("3000")
		);
		employeeService.create(employee);

		assertThat(employeeService.getAllEmployees())
				.isNotEmpty()
				.anyMatch(e -> e.getName().equals("John Doe"));
		System.out.println("Тест создания сотрудника успешно выполнен!");
	}

	@Test
	void testCreateAtm() {
		Bank bank = new Bank("ATM Bank");
		bankService.create(bank);

		BankOffice office = new BankOffice("ATM Office", "789 Road", bank, true, true, true, true, true, BigDecimal.TEN, BigDecimal.TEN);
		bankOfficeService.create(office);

		BankAtm atm = new BankAtm(
				"ATM 1",
				"789 Road",
				true, true, true,
				BigDecimal.ZERO,
				office
		);
		atmService.create(atm);

		assertThat(atmService.getAllAtms())
				.isNotEmpty()
				.anyMatch(a -> a.getName().equals("ATM 1"));
		System.out.println("Тест создания банкомата успешно выполнен!");
	}

	@Test
	void testCreateUser() {
		Bank bank = new Bank("User Bank");
		bankService.create(bank);

		User user = new User(
				"Test User",
				LocalDate.of(1990, 1, 1),
				"Test Company",
				new BigDecimal("5000"),
				bank,
				new BigDecimal("700")
		);
		userService.create(user);

		List<User> users = userService.getAllUsers();
		assertThat(users)
				.isNotEmpty()
				.anyMatch(u -> u.getName().equals("Test User"));
		System.out.println("Тест создания пользователя успешно выполнен!");
	}

	@Test
	void testCreatePaymentAccount() {
		Bank bank = new Bank("Payment Bank");
		bankService.create(bank);

		User user = new User(
				"Payment User",
				LocalDate.now(),
				"Company",
				BigDecimal.valueOf(5000),
				bank,
				BigDecimal.valueOf(700)
		);
		userService.create(user);

		PaymentAccount account = new PaymentAccount(
				user,
				bank,
				BigDecimal.valueOf(1000)
		);
		paymentAccountService.create(account);

		assertThat(paymentAccountService.getAllPaymentAccounts())
				.isNotEmpty()
				.anyMatch(a -> a.getBalance().equals(BigDecimal.valueOf(1000)));
		System.out.println("Тест создания платёжного аккаунта успешно выполнен!");
	}

	@Test
	void testCreateCreditAccount() {
		Bank bank = new Bank("Credit Bank");
		bankService.create(bank);

		User user = new User(
				"Credit User",
				LocalDate.now(),
				"Company",
				BigDecimal.valueOf(5000),
				bank,
				BigDecimal.valueOf(700)
		);
		userService.create(user);

		CreditAccount creditAccount = new CreditAccount(
				user,
				bank,
				BigDecimal.valueOf(5000),
				BigDecimal.valueOf(2000)
		);
		creditAccountService.create(creditAccount);

		assertThat(creditAccountService.getAllCreditAccounts())
				.isNotEmpty()
				.anyMatch(c -> c.getRemainingDebt().equals(BigDecimal.valueOf(2000)));
		System.out.println("Тест создания кредитного аккаунта успешно выполнен!");
	}
}
