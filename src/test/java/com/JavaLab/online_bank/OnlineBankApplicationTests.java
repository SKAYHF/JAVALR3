package com.JavaLab.online_bank;

import com.JavaLab.online_bank.entity.Bank;
import com.JavaLab.online_bank.service.BankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OnlineBankApplicationTests {

	@Autowired
	private BankService bankService;

	@Test
	void contextLoads() {
		// Проверяем, что контекст Spring загружается
		System.out.println("Контекст приложения успешно загружен!");
	}

	@Test
	void testCreateBank() {
		// Создаём банк через сервис
		Bank bank = new Bank("Test Bank");
		bankService.create(bank);

		// Проверяем, что банк успешно создан
		assertThat(bankService.getAllBanks())
				.isNotEmpty()
				.anyMatch(b -> b.getName().equals("Test Bank"));

		System.out.println("Тест создания банка успешно выполнен!");
	}
}
