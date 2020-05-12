package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public void insertEmployee() throws SQLException;
	
	public List<Employee> getEmployeeList() throws SQLException;
	
	public void eLogin() throws SQLException;
	

}
