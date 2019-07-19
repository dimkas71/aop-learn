package ua.selftaught;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.selftaught.model.Account;
import ua.selftaught.model.FibonacciProducer;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/aspectj.xml")) {

			Account account = (Account) ctx.getBean("account");

			System.out.println("Balance: " + account.balance());
			System.out.println(account.getUuid());

			account.deposit(new BigDecimal(100));

			account.withdraw(new BigDecimal(99));
			
			System.out.println("Balance = " + account.balance());
			
			FibonacciProducer fbp = (FibonacciProducer) ctx.getBean(FibonacciProducer.class);
			
			System.out.println(fbp.generate(45L));
		}
		

	}

}
