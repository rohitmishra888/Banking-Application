package com.assignment.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

import com.assignment.Controller.BankController;
import com.assignment.Model.Account;

import net.miginfocom.swing.MigLayout;

public class SelectView extends JFrame {
	
	private JLabel header;
	private JLabel selectAccount;
	private ArrayList<String> option;
	private JList<String> list;
	private JButton ok;
	private JButton cancel;
	private BankController controller;
	
	public SelectView(BankController controller) {
		super("Banking Application");
		this.controller = controller;
    	setSize(400, 300);
    	setBounds(100, 100, 550, 450);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	setLayout(new MigLayout(""));
    	
    	header = new JLabel("Bank Machine Simulation v1.0 >");
    	selectAccount = new JLabel("Select Account: ");
    	option = new ArrayList<String>();
    	for(Account a:controller.getAccountList()) {
    		option.add(a.getAccountName());
    	}
    	
    	list  = new JList<>(option.toArray(new String[0]));
    	//list.setBounds(100,100, 75,75);
    	list.setPreferredSize(new Dimension(100,100));
    	DefaultListCellRenderer renderer = new DefaultListCellRenderer();
    	renderer.setHorizontalAlignment(SwingConstants.CENTER);
    	list.setCellRenderer(renderer);
    	
    	ok =new JButton("Ok");
    	cancel = new JButton("Cancel");
    	
    	add(header,"wrap");
    	add(selectAccount,"split 2");
    	add(list,"wrap");
    	add(ok,"split 2");
    	add(cancel);
    	
    	ok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String selected = list.getSelectedValue();
        		for(Account a:controller.getAccountList()) {
            		if(a.getAccountName()==selected) {
            			controller.setAccount(a);
            			break;
            		}
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
