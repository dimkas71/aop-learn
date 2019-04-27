package ua.selftaught;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.selftaught.model.Account;

public class Main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/aspectj.xml")) {

			Account account = (Account) ctx.getBean("account");

			System.out.println("Balance: " + account.balance());
			System.out.println(account.getUuid());

			account.deposit(new BigDecimal(100));

			account.withdraw(new BigDecimal(99));

			System.out.println("Balance " + account.balance());
		}
		

	}

}
