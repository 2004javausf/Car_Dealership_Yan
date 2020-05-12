package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.menu.EmployeeMenu;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;


public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	static Scanner scan = new Scanner(System.in);

	@Override
	public void insertEmployee() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to our MENU for adding a New Employee!");
		System.out.println("Username:");
		String us = scan.nextLine();
		System.out.println("Password:");
		String pa = scan.nextLine();
		System.out.println("Name:");
		String na = scan.nextLine();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO EMPLOYEE VALUES(MYSEQ2.NEXTVAL" + ",'"+us+"','"+pa+"','"+na+"')";
		stmt.executeQuery(sql);	
		
	}

	@Override
	public List<Employee> getEmployeeList() throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		Employee e = null;
		while(rs.next()) {
			e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			employeeList.add(e);
		}
		return employeeList;
	}

	@Override
	public void eLogin() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter employee username:");
		String username = scan.nextLine();
		System.out.println("Enter employee password:");
		String password = scan.nextLine();
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_USERNAME = '"+username+"' AND EMPLOYEE_PASSWORD = '"+password+"'");
		if(rs.next() == true) {
			System.out.println("Login in success!");
			LogThis.LogIt("info", rs.getString(4)+ " has Logged in.");
		} else {
			System.out.println("Your account information is not in the system.");
			EmployeeMenu.eLoginMenu();
		}
		
	}

}
