package com.assignment.Model;

import java.io.Serializable;
import java.util.ArrayList;

import com.assignment.Utilities.InsufficientBalanceExecption;

public abstract class Account implements Serializable {
	
	private String accountName;
	private double accountBalance;
	private ArrayList<Transaction> transactionList;
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public Account(String accountName, double initialDeposit) {
        this.accountName = accountName;
        this.accountBalance = initialDeposit;
        this.transactionList = new ArrayList<>();
        this.transactionList.add(new Transaction("Initial deposit", initialDeposit));
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientBalanceExecption;

    public ArrayList<Transaction> getTransactions() {
        return transactionList;
    }

}
