package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;


public interface CustomerDAO {
	
	public void insertCustomer() throws SQLException;
	
	public List<Customer> getCustomerList() throws SQLException;
	
	public String cLogin() throws SQLException;

}