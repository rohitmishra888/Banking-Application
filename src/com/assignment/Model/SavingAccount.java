package com.assignment.Model;

import com.assignment.Utilities.InsufficientBalanceExecption;

public class SavingAccount extends Account {

	public SavingAccount(String accountName, double initialDeposit) {
		super(accountName, initialDeposit);
	}

	@Override
	public void deposit(double amount) {
		this.setAccountBalance(this.getAccountBalance()+amount);
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceExecption {
		if(this.getAccountBalance()<amount){
			throw new InsufficientBalanceExecption();
		}
		else {
			this.setAccountBalance(this.getAccountBalance()-amount);
			this.setAccountBalance(this.getAccountBalance()-0.50);
		}
		
		
	}

	@Override
	public String toString() {
		String show = "Savings Accounts\nAccount Description: "+getAccountName()+"\nAccount Type: Savings Account\nCurrent Balance: $"+getAccountBalance();
		for(Transaction t:getTransactionList()) {
			show += "\n"+t.toString();
		}
		return show;
	}

}
