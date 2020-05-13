package com.revature.beans;

public class OfferPayment {
	
	private int offerid;
	private int cusid;
	private String cusname;
	private int carid;
	private String carname;
	private double price;
	private double balance;
	private double payment;

	public OfferPayment(int offerid, int cusid, String cusname, int carid, String carname, double price, double balance,
			double payment) {
		super();
		this.offerid = offerid;
		this.cusid = cusid;
		this.cusname = cusname;
		this.carid = carid;
		this.carname = carname;
		this.price = price;
		this.balance = balance;
		this.payment = payment;

	}
	public int getOfferid() {
		return offerid;
	}
	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
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
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}


	@Override
	public String toString() {
		return "CUSTOMER PAYMENTS: [Offer ID =" + offerid + ", Customer ID =" + cusid + ", Customer Name =" + cusname + ", Car ID =" + carid
				+ ", Car NAME =" + carname + ", Price =$" + price + ", Balance =$" + balance + ", Payment =$" + payment +"]\n";
	}

	

}
