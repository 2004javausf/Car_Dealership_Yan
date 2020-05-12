package com.revature.beans;

public class Customer {
	
	
    private int id;
	private String password;
	private String name;
	private String car;
	private double payments;
	private double balance;
	
	public Customer(int id, String password, String name, String car, double payments, double balance) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.car = car;
		this.payments = payments;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public double getPayments() {
		return payments;
	}

	public void setPayments(double payments) {
		this.payments = payments;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", password=" + password + ", name=" + name + ", car=" + car + ", payments="
				+ payments + ", balance=" + balance + "]\n";
	}

	
	
	

}
