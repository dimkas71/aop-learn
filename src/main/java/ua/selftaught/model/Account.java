package ua.selftaught.model;

import java.math.BigDecimal;

public class Account {
	
	
	private String uuid;
	private BigDecimal balance = BigDecimal.ZERO;

	public Account(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void deposit(BigDecimal sum) {
		this.balance = this.balance.add(sum);
	}
	
	public void withdraw(BigDecimal sum) {
		
		BigDecimal afterWithdrawing = this.balance.subtract(sum);
		
		if (afterWithdrawing.signum() == -1) {
			throw new RuntimeException("Not enough money on the account");
		}
		
		this.balance = afterWithdrawing;
	}
	
	public BigDecimal balance() {
		return this.balance;
	}

	@Override
	public String toString() {
		return String.format("Account(balance=%s)", balance);
	}
	
}
