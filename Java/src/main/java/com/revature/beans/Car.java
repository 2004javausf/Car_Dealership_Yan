package com.revature.beans;

public class Car{

	private int id;
    private String name;
	private String information;
	private double price;
	private String status;
	
	
	public Car(int id, String name, String information, double price, String status) {
		super();
		this.id = id;
		this.name = name;
		this.information = information;
		this.price = price;
		this.status = status;
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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", information=" + information + ", price=$" + price + ", status="
				+ status + "]\n";
	}



	
	
	
	

}