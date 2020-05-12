package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.CarCustomerMenu;

public interface CarDAO {
	
	public void insertCar() throws SQLException;
	
	public void updateCarList(int id) throws SQLException;
	
	public void deleteCarList() throws SQLException;
	
	public List<Car> getCarList() throws SQLException;
	
	public List<CarCustomerMenu> getAvailable() throws SQLException;


	


}
