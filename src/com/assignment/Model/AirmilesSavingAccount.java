package com.assignment.Model;

import com.assignment.Utilities.InsufficientBalanceExecption;

public class AirmilesSavingAccount extends Account {
	
	protected double airmiles;
	protected int earnedAirmile;

	public AirmilesSavingAccount(String accountName, double initialDeposit) {
		super(accountName, initialDeposit);
		 earnedAirmile = (int) (initialDeposit/30);
		this.airmiles = 10 + earnedAirmile;
	}

	@Override
	public void deposit(double amount) {
		this.setAccountBalance(this.getAccountBalance()+amount);
		 earnedAirmile = (int) (amount/30);
		this.airmiles += earnedAirmile;
		
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceExecption {
		if(this.getAccountBalance()<amount){
			throw new InsufficientBalanceExecption();
		}
		else {
			this.setAccountBalance(this.getAccountBalance()-amount);
			this.setAccountBalance(this.getAccountBalance()-0.75);
		}
		
	}
	
	@Override
	public String toString() {
		String show = "AirMiles Savings Accounts\nAirMiles Balance: "+airmiles+"\nAccount Description: "+getAccountName()+"\nAccount Type: Airmiles Savings Account\nCurrent Balance: $"+getAccountBalance();
		for(Transaction t:getTransactionList()) {
			show += "\n"+t.toString();
		}
		return show;
	}

}
