package com.assignment;

import javax.swing.SwingUtilities;

import com.assignment.Controller.BankController;
import com.assignment.View.MasterView;

public class StartApplication {
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MasterView masterView = new MasterView();

            masterView.setVisible(true);
            masterView.setResizable(true);
        });
    }
}
