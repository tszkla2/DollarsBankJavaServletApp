package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Model Class for the Savings Account
public class SavingsAccount extends Account {

	private double balance;
	private String accountID;
	private String password;
	private LocalDateTime now = LocalDateTime.now(); 
	
	public List<String> transactionHistory = new ArrayList<String>();
	
	public SavingsAccount() {
		super();
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	//Withdraw functionality that displays withdraw and time as well as adds it to the history
	@Override
	public void withdraw(double money) {
		now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		String ldt = now.format(format); 
		
		balance = balance - money;
		
		addHistory("Withdrawn $" + money + " from account ["+ accountID +"]. " + "Balance - $" + balance + " as of " + ldt);
		System.out.println();
	}

	//Deposit functionality that displays deposit and time as well as adds it to the history
	@Override
	public void deposit(double money) {
		now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		String ldt = now.format(format); 
		
		balance = balance + money;
		
		addHistory("Deposited $" + money + " into account ["+ accountID +"]. " + "Balance - $" + balance + " as of " + ldt);
		System.out.println();
	}

	@Override
	public void addHistory(String transaction) {
		transactionHistory.add(transaction);
		
	}

	//Add transactions to the history and only displays the 5 most recent
	@Override
	public ArrayList<String> displayHistory() {
		ArrayList<String> h = new ArrayList<String>();
		int size = transactionHistory.size();
		int skip = 0;
		
		for (String string : transactionHistory) {
			h.add(string);
		}
		
		if(size > 5) {
			skip = size - 5;
			
				while(skip > 0) {
					h.remove(skip - 1);
					skip--;
				}
			}
		return h;
	}

	//Transfer functionality that displays transfer and time as well as adds it to the history
	@Override
	public void transfer(double money, String transferID) {
		now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		String ldt = now.format(format); 
		
		balance = balance - money;
		
		addHistory("Transferred $" + money + " into account ["+ transferID +"]. " + "Balance - $" + balance + " as of " + ldt);
		System.out.println();
	}

	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + ", accountID=" + accountID + ", password=" + password
				+ ", transactionHistory=" + transactionHistory + "]";
	}


}
