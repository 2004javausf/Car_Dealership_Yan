package com.revature.beans;

public class CarCustomerMenu {
	private int id;
    private String name;
	private String information;
	private double price;
	public CarCustomerMenu(int id, String name, String information, double price) {
		super();
		this.id = id;
		this.name = name;
		this.information = information;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CarCustomerMenu [id=" + id + ", name=" + name + ", information=" + information + ", price=" + price
				+ "]\n";
	}

	
}
