package com.assignment.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.assignment.Model.Account;
import com.assignment.Model.SavingAccount;
import com.assignment.Utilities.InsufficientBalanceExecption;

public class SavingAccountTest {
	static Account account;
	
	@BeforeClass
	public static void setUp() {
		account = new SavingAccount("Test Account", 90);
	}
	
	
	//Test For Account Type
	@Test
	public void test1() {
		String expectedClass = "class com.assignment.Model.SavingAccount";
		assertEquals(expectedClass,account.getClass().toString());
	}
	
	//Verify Account Name
	@Test
	public void test2() {
		String expectedName = "Test Account";
		assertEquals(expectedName,account.getAccountName());
	}
	
	//Verify Account Amount
	@Test
	public void test3() {
		Double expectedAmount = 90.00;
		assertEquals(expectedAmount,account.getAccountBalance());
	}
	
	
	//Verify Amount after deposit
	@Test
	public void test4() {
		account.deposit(50.00);
		Double expectedAmount = 140.00;
		assertEquals(expectedAmount,account.getAccountBalance());
		
	}
	
	//Verify Amount after Withdraw
	@Test
	public void test5() throws InsufficientBalanceExecption {
		account.withdraw(45.00);
		Double expectedAmount = 94.50;
		assertEquals(expectedAmount,account.getAccountBalance());
	}

}
