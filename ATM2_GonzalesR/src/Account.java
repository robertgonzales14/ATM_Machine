/**
 *Date: Feb 18, 2021
 *Title: ASS2
 *@author Robert Gonzales
 *@version
 *
 *
 */
public class Account {
  
private String customerName;
private int customerId;
private double balance;
private double annualIR;
private int accountStat;

//Getters and Setters
public Account(int customerId, String name) {
	this.customerId = customerId;
	customerName = name;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public int getcustomerId() {
	return customerId;
}
public void setcustomerId(int customerId) {
	this.customerId = customerId;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double getAnnualIR() {
	return annualIR;
}
public void setAnnualIR(double annualIR) {
	this.annualIR = annualIR;
	}
public int getAccountstat() {
	return accountStat;
	}
public void setAccountstat(int accountStat) {
	this.accountStat = accountStat;
	}
public void deposit(double deposit) {
	balance += deposit;
	}

public void withdraw(double withdraw) { 
	if(withdraw <= this.balance) //If withdraw is less than or equal to the current balance execute this command
	this.balance -= withdraw;
	}
}