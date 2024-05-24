package com.assignment.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.assignment.Controller.BankController;

import net.miginfocom.swing.MigLayout;

public class DeleteView extends JFrame {
	
	private JLabel header;
	private JLabel labelDescription;
	private JButton delete;
	private JButton cancel;
	private BankController controller;
	
	public DeleteView(BankController controller) {
		super("Banking Application");
		this.controller = controller;
    	setSize(400, 300);
    	setBounds(100, 100, 550, 450);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	setLayout(new MigLayout(""));
    	
    	header = new JLabel("Bank Machine Simulation v1.0 >");
    	labelDescription = new JLabel("Delete Current Account? "+controller.getAccount().getAccountName());
    	delete =new JButton("Delete");
    	cancel = new JButton("Cancel");
    	
    	
    	add(header,"wrap");
    	add(labelDescription,"wrap");
    	add(delete,"gapleft 180px,split 2");
    	add(cancel);
    	
    	delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.deleteAccount();
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
