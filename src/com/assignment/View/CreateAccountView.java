package com.assignment.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.assignment.Controller.BankController;

import net.miginfocom.swing.MigLayout;

public class CreateAccountView extends JFrame {

	private BankController controller;
	private JLabel header;
	private JLabel lblAccountType;
	private JList<String> accountType;
	private String[] types = { "Savings Account", "Airmiles Savings Account" };
	private JLabel accountDescription;
	private JTextField description;
	private JLabel startingBalance;
	private JTextField amount;
	private JButton ok;
	private JButton cancel;
	private JLabel numberFormatWarning;

	public CreateAccountView(BankController controller) {
		super("Create Acoount");
		this.controller = controller;
		setSize(400, 300);
		setBounds(100, 100, 550, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new MigLayout(""));

		header = new JLabel("Bank Machine Simulation v1.0 >");
		lblAccountType = new JLabel("Select Acount Type:");
		accountType = new JList<>(types);
		accountType.setSelectedIndex(0);
		accountDescription = new JLabel("Account Description:");
		description = new JTextField();
		description.setColumns(25);
		startingBalance = new JLabel("Starting Balance: $");
		amount = new JTextField();
		amount.setColumns(6);
		ok = new JButton("Ok");
		cancel = new JButton("Cancel");
		numberFormatWarning = new JLabel("0.00 format for amount required");
		numberFormatWarning.setVisible(false);

		add(header, "wrap");
		add(lblAccountType, "split 2");
		add(accountType, "wrap");
		add(accountDescription, "split 2");
		add(description, "wrap");
		add(startingBalance, "split 2");
		add(amount, "gapleft 20px,wrap");
		add(ok, "gapleft 125px,split 2");
		add(cancel,"wrap");
    	add(numberFormatWarning,"gapleft 160px");

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accountDescription;
				double initialAmount;
				try {
					accountDescription = description.getText();
					initialAmount = Double.valueOf(amount.getText());
					if (accountType.getSelectedIndex() == 0) {
						controller.createSavingAccount(accountDescription, initialAmount);
					} else {
						controller.createAirmileSavingAccount(accountDescription, initialAmount);
					}
				} catch (NumberFormatException ex) {
					numberFormatWarning.setVisible(true);
				}

				setVisible(false);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		setVisible(true);
	}

}
