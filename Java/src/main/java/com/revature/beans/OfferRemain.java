package com.revature.beans;

public class OfferRemain {
	private String cusname;
	private String carname;
	private double price;
	private double balance;
	private double monthly24;
	private double monthly36;
	
	public OfferRemain(String cusname, String carname, double price, double balance, double monthly24,
			double monthly36) {
		super();
		this.cusname = cusname;
		this.carname = carname;
		this.price = price;
		this.balance = balance;
		this.monthly24 = monthly24;
		this.monthly36 = monthly36;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMonthly24() {
		return monthly24;
	}
	public void setMonthly24(double monthly24) {
		this.monthly24 = monthly24;
	}
	public double getMonthly36() {
		return monthly36;
	}
	public void setMonthly36(double monthly36) {
		this.monthly36 = monthly36;
	}
	@Override
	public String toString() {
		return "Remain Payments [Customer name=" + cusname + ", Car name=" + carname + ", Price=$" + price + ", Balance=$" + balance
				+ ", 24 Monthly=$" + monthly24 + ",  36 monthly=$" + monthly36 + "]\n";
	}
	
	
	

}
