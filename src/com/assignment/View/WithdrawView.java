package com.assignment.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.assignment.Controller.BankController;
import com.assignment.Utilities.InsufficientBalanceExecption;

import net.miginfocom.swing.MigLayout;

public class WithdrawView extends JFrame {

	private JLabel header;
	private JLabel labelAmount;
	private JTextField amount;
	private JLabel labelDescription;
	private JTextField description;
	private JButton ok;
	private JButton cancel;
	private JLabel warning;
	private JLabel numberFormatWarning;

	private BankController controller;

	public WithdrawView(BankController controller) {
		super("Withdraw Amount");
		this.controller = controller;
		setSize(400, 300);
		setBounds(100, 100, 550, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new MigLayout(""));

		header = new JLabel("Bank Machine Simulation v1.0 >");
		labelAmount = new JLabel("Enter Amount to Withdraw: $");
		amount = new JTextField();
		amount.setColumns(6);
		labelDescription = new JLabel("Transaction Description: ");
		description = new JTextField();
		description.setColumns(25);
		ok = new JButton("Ok");
		cancel = new JButton("Cancel");
		warning = new JLabel("Insufficient Balance");
		warning.setVisible(false);
		numberFormatWarning = new JLabel("0.00 format for amount required");
		numberFormatWarning.setVisible(false);

		add(header, "wrap");
		add(labelAmount, "split 2");
		add(amount, "wrap");
		add(labelDescription, "gapleft 19px,split 2");
		add(description, "wrap");
		add(warning, "wrap");
		add(ok, "gapleft 170px,split 2");
		add(cancel,"wrap");
    	add(numberFormatWarning,"gapleft 160px");
    	
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String accountDescription = description.getText();
					double withdrawAmount = Double.valueOf(amount.getText());
					controller.withdraw(accountDescription, withdrawAmount);
					setVisible(false);
				} catch (InsufficientBalanceExecption e1) {
					warning.setVisible(!warning.isVisible());
				} catch (NumberFormatException ex) {
					numberFormatWarning.setVisible(true);
				}

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
