package com.assignment.Controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.assignment.Model.Account;
import com.assignment.Model.AirmilesSavingAccount;
import com.assignment.Model.SavingAccount;
import com.assignment.Model.Transaction;
import com.assignment.Utilities.InsufficientBalanceExecption;

public class BankController {

	protected ArrayList<Account> accountList;
	protected Account account;

	public BankController() {
		accountList = new ArrayList<>();
		loadAccounts("accounts.dat");
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	// Creating a Saving Account
	public void createSavingAccount(String accountName, double initialDeposit) {
		this.account = new SavingAccount(accountName, initialDeposit);
		accountList.add(this.account);
		System.out.println("Saving Account Created");
	}

	// Creating Airmile Savings Account
	public void createAirmileSavingAccount(String accountName, double initialDeposit) {
		this.account = new AirmilesSavingAccount(accountName, initialDeposit);
		accountList.add(this.account);
		System.out.println("Airmile Account Created");
	}

	// This method is depositing money in account.
	public void deposit(String description, double amount) {
		this.account.deposit(amount);
		this.account.getTransactionList().add(new Transaction(description, amount));
	}

	// This method is withdrawing money from account.
	public void withdraw(String description, double amount) throws InsufficientBalanceExecption {
		account.withdraw(amount);
		this.account.getTransactionList().add(new Transaction(description, amount));
	}

	public void details() {
		System.out.println(this.account.getAccountName() + "\n Account Balance=>" + this.account.getAccountBalance());
	}

	public void deleteAccount() {
		accountList.remove(account);
		account = null;
	}

	// This method is used to show Transactions.
	public String transactionsView() {
		return this.account.toString();
	}

	public void saveToFile(String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			for (Account a : accountList) {
				oos.writeObject(a);
			}
			System.out.println("Account data saved successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    private void loadAccounts(String filename) {
        try (
        		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                Account account = (Account) ois.readObject();
                accountList.add(account);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Accounts data loaded successfully.");
    }


}
