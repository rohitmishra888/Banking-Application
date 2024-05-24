package com.assignment.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

public class TransactionView extends JFrame {
	
	private JLabel header;
	private JLabel label;
	private JTextPane pane;
	private JScrollPane scrollPane;
	private JButton ok;
	
	public TransactionView(String show) {
		super("Transactions");
		setSize(400, 300);
		setBounds(100, 100, 550, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new MigLayout(""));
    	
    	header = new JLabel("Bank Machine Simulation v1.0 >");
    	label = new JLabel("Transactions of Currently Selected Account:");
    	pane = new JTextPane();
    	pane.setText(show);
    	scrollPane = new JScrollPane(pane);
    	scrollPane.setPreferredSize(new Dimension(400, 400));
		ok =new JButton("Ok");
		
		add(header,"wrap");
		add(label,"wrap");
		add(scrollPane,"Wrap");
		add(ok,"gapleft 125px,split 2");
		
		ok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
		
		setVisible(true);
	}
	
	
	

}
