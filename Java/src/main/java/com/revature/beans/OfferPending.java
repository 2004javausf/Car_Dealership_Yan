package com.revature.beans;

public class OfferPending {
    private int id;
	private int carid;
	private int cusid;
	private String carname;
	private double price;
	private String cusname;
	private String status;
	public OfferPending(int id, int carid, int cusid, String carname, double price, String cusname, String status) {
		super();
		this.id = id;
		this.carid = carid;
		this.cusid = cusid;
		this.carname = carname;
		this.price = price;
		this.cusname = cusname;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
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
	public String getCusname() {
		return cusname;
	}
	public void setCusname(String cusname) {
		this.cusname = cusname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OfferPending [id=" + id + ", carid=" + carid + ", cusid=" + cusid + ", carname=" + carname + ", price="
				+ price + ", cusname=" + cusname + ", status=" + status + "]\n";
	}
	
}
