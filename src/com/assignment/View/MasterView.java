package com.assignment.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.assignment.Controller.BankController;
import com.assignment.Model.Transaction;

import net.miginfocom.swing.MigLayout;

public class MasterView extends JFrame {
	 private JLabel header;
	    private JButton select;
	    private JLabel selectAccount;
	    private JButton deposit;
	    private JLabel lblDeposit;
	    private JButton withdraw;
	    private JLabel lblWithdraw;
	    private JButton create;
	    private JLabel lblCreate;
	    private JButton delete;
	    private JLabel lblDelete;
	    private JButton viewTransactions;
	    private JLabel lblView;
	    private JButton quit;
	    private JLabel lblSave;
	    
	    private BankController controller;
	    
	    public MasterView() {
	    	super("Banking Application");
	    	this.controller = new BankController();
	    	setSize(400, 300);
	    	setBounds(100, 100, 550, 450);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	setLayout(new MigLayout(""));
	    	
	    	header = new JLabel("Bank Machine Simulation v1.0 >");
	        select = new JButton("Select");
	        select.setPreferredSize(new Dimension(100, 20));
	        selectAccount = new JLabel("Select Account");
	        deposit = new JButton("Deposit");
	        deposit.setPreferredSize(new Dimension(100, 20));
	        lblDeposit = new JLabel("Deposit sum to account");
	        withdraw = new JButton("Withdraw");
	        withdraw.setPreferredSize(new Dimension(100, 20));
	        lblWithdraw = new JLabel("Withdraw sum from account");
	        create = new JButton("Create");
	        create.setPreferredSize(new Dimension(100, 20));
	        lblCreate = new JLabel("Create account");
	        delete = new JButton("Delete");
	        delete.setPreferredSize(new Dimension(100, 20));
	        lblDelete = new JLabel("Delete account");
	        viewTransactions = new JButton("View");
	        viewTransactions.setPreferredSize(new Dimension(100, 20));
	        lblView = new JLabel("View account transactions");
	        quit = new JButton("Quit");
	        quit.setPreferredSize(new Dimension(100, 20));
	        lblSave = new JLabel("Save and Quit");
	        
	        
	        //Disabling buttons when there is no accounts
	        if(controller.getAccountList().isEmpty()) {
	        	select.setEnabled(false);
	        	deposit.setEnabled(false);
	        	withdraw.setEnabled(false);
	        	delete.setEnabled(false);
	        	viewTransactions.setEnabled(false);
	        }
	        
	        
	        //Adding Components in frame
	        add(header,"wrap");
	        add(select,"split 2");
	        add(selectAccount,"wrap");
	        add(deposit,"split 2");
	        add(lblDeposit,"wrap");
	        add(withdraw,"split 2");
	        add(lblWithdraw,"wrap");
	        add(create,"split 2");
	        add(lblCreate,"wrap");
	        add(delete,"split 2");
	        add(lblDelete,"wrap");
	        add(viewTransactions,"split 2");
	        add(lblView,"wrap");
	        add(quit,"split 2");
	        add(lblSave,"wrap");
	        
	        
	        //Handling create Button
	        create.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CreateAccountView createAccountView = new CreateAccountView(controller);
	        		createAccountView.setVisible(true);
	        		select.setEnabled(true);
		        	deposit.setEnabled(true);
		        	withdraw.setEnabled(true);
		        	delete.setEnabled(true);
		        	viewTransactions.setEnabled(true);
	        		
	        	}
	        });
	        
	        //Handling view Transactions
	        viewTransactions.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		TransactionView transactionsView = new TransactionView(controller.transactionsView());
	        		transactionsView.setVisible(true);
	        	}
	        });
	        
	        // Handling Select Account
	        select.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		SelectView selectView = new SelectView(controller);
	        		selectView.setVisible(true);
	        	}
	        });
	        
	        //Handling withdraw button
	        withdraw.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		WithdrawView withdrawView = new WithdrawView(controller);
	        		withdrawView.setVisible(true);
	        	}
	        });
	        
	        //Handling deposit button
	        deposit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		DepositView depositView = new DepositView(controller);
	        		depositView.setVisible(true);
	        	}
	        });
	        
	        //Handling delete Button
	        delete.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		DeleteView deleteView = new DeleteView(controller);
	        		deleteView.setVisible(true);
	        	}
	        });
	        
	        //Handling quit Button
	        quit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		controller.saveToFile("accounts.dat");
	        		setVisible(false);
	        	}
	        });
	        
	        
	        setVisible(true);

	    }

}
