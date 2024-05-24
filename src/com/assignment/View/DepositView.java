package com.assignment.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.assignment.Controller.BankController;

import net.miginfocom.swing.MigLayout;

public class DepositView extends JFrame {
	
	private JLabel header;
	private JLabel labelAmount;
	private JTextField amount;
	private JLabel labelDescription;
	private JTextField description;
	private JButton ok;
	private JButton cancel;
	private BankController controller;
	private JLabel numberFormatWarning;
	
	public DepositView(BankController controller) {
		super("Banking Application");
		this.controller = controller;
    	setSize(400, 300);
    	setBounds(100, 100, 550, 450);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	setLayout(new MigLayout(""));
    	
    	header = new JLabel("Bank Machine Simulation v1.0 >");
    	labelAmount = new JLabel("Enter Amount to Deposit: $");
    	amount = new JTextField();
    	amount.setColumns(6);
    	labelDescription = new JLabel("Transaction Description: ");
    	description = new JTextField();
    	description.setColumns(25);
    	ok =new JButton("Ok");
    	cancel = new JButton("Cancel");
    	numberFormatWarning = new JLabel("0.00 format for amount required");
		numberFormatWarning.setVisible(false);
    	
    	add(header,"wrap");
    	add(labelAmount,"split 2");
    	add(amount,"wrap");
    	add(labelDescription,"gapleft 14px,split 2");
    	add(description,"wrap");
    	add(ok,"gapleft 160px,split 2");
    	add(cancel,"wrap");
    	add(numberFormatWarning,"gapleft 160px");
    	
    	ok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		String accountDescription = description.getText();
        		double depositAmount = Double.valueOf(amount.getText());
        		controller.deposit(accountDescription,depositAmount);
        		}
        		catch (NumberFormatException ex) {
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
