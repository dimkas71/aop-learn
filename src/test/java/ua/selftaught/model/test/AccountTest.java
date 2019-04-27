package ua.selftaught.model.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ua.selftaught.model.Account;

@DisplayName("Account tests")
class AccountTest {
	
	
	private Account account;
	
	
	@BeforeEach
	void setUp() {
		this.account = new Account(UUID.randomUUID().toString());
	}
	
	
	
	@Test
	@DisplayName("At creating an account balance should be ZERO")
	void accountShouldBeCreatedProperly() {
		//assert
		Assertions.assertEquals(BigDecimal.ZERO, account.balance(), () -> "Should be ZERO");
		
		//Test if a balance can not be changed from a caller accidentally
		BigDecimal balance = account.balance();
		balance.add(new BigDecimal(1000));
		Assertions.assertEquals(BigDecimal.ZERO, account.balance(), () -> "Should be ZERO");
		
	}
	
	@Test
	@DisplayName("if i deposit 100 units and then withdraw 50 units the balance should be 50")
	void testDepositWithdrawing() {
		account.deposit(new BigDecimal(100));
		account.withdraw(new BigDecimal(50));
		
		Assertions.assertEquals(new BigDecimal(50), account.balance(), () -> "Should be equal 50 units after all"); 
		
	}
	
	@Test
	@DisplayName("If we withdraw greater than the balance contains exception should be thrown")
	void whenGreaterThanBalanceExceptionShouldBeThrown() {
		final String MESSAGE = "Not enough money on the account";
		
		account.deposit(new BigDecimal(100));
				
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			account.withdraw(new BigDecimal(200));
		});
		
		Assertions.assertEquals(MESSAGE, exception.getMessage(), () -> {
			return "Should be equal: " + MESSAGE;
		});
		
	}
	
	

}
