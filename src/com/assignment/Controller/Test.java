package com.assignment.Controller;

public class Test {

	public static void main(String[] args) {
		
		BankController controller = new BankController();
		controller.createSavingAccount("my saving account",200.00);
		controller.details();
		controller.createAirmileSavingAccount("my airmiles account", 150);
		controller.details();

	}

}
