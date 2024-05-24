package com.assignment.Model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
	
	private String description;
    private LocalDateTime date;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.date = LocalDateTime.now();
        this.amount = amount;
    }

	@Override
	public String toString() {
		return date +": $" + amount + "[" + description+"]";
	}
    
    


}
