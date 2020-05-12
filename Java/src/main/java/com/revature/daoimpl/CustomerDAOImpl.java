package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;
import com.revature.menu.CustomerMenu;
import com.revature.menu.StartMenu;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class CustomerDAOImpl implements CustomerDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	static Scanner scan = new Scanner(System.in);

	@Override
	public void insertCustomer() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to our registration MENU!");
		System.out.println("Username:");
		String us = scan.nextLine();
		System.out.println("Password:");
		String pa = scan.nextLine();
		System.out.println("Name:");
		String na = scan.nextLine();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO CUSTOMER VALUES(MYSEQ3.NEXTVAL" + ",'"+us+"','"+pa+"','"+na+"','0','0')";
		LogThis.LogIt("info", sql+ " A new Customer Account has been created.");
		stmt.executeQuery(sql);	
		
	}

	@Override
	public List<Customer> getCustomerList() throws SQLException {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6));
			customerList.add(c);
		}
		return customerList;
	}

	@Override
	public String cLogin() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter customer username:");
		String username = scan.nextLine();
		System.out.println("Enter customer password:");
		String password = scan.nextLine();
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT CUSTOMER_USERNAME, CUSTOMER_PASSWORD FROM CUSTOMER WHERE CUSTOMER_USERNAME = '"+username+"' AND CUSTOMER_PASSWORD = '"+password+"'");
		if(rs.next() == true) {
			System.out.println("Login in success!");
			LogThis.LogIt("info", rs.getString(4)+ " has Logged in.");
		} else {
			System.out.println("Your account information is not in the system.");
			System.out.println("Would you like to try again? (y/n)");
			String choice = scan.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				CustomerMenu.cLoginMenu();
			}else if(choice.equalsIgnoreCase("n")) {
				StartMenu.startMenu();
			}else {
				System.out.println("Going back to the main menu.");
				StartMenu.startMenu();
		}
		}
		return username;

	}
}
