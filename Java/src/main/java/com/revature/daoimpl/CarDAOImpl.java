package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.CarCustomerMenu;
import com.revature.dao.CarDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class CarDAOImpl implements CarDAO{
public static ConnFactory cf = ConnFactory.getInstance();
static Scanner scan = new Scanner(System.in);	
	
	@Override
	public void insertCar() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Make:");
		Scanner sc =new Scanner(System.in);
		String make = sc.next();
		
		System.out.println("Features:");
		Scanner sc2 =new Scanner(System.in);
		String info = sc2.nextLine();
		
		System.out.println("Price:");
		Scanner sc3 =new Scanner(System.in);
		Double price = sc3.nextDouble();
		
//		<Statement to execute a query>
//		Connection conn = cf.getConnection();
//		Statement stmt = conn.createStatement();
//		String sql = "INSERT INTO CAR VALUES(MYSEQ.NEXTVAL" + ",'"+make+"','"+info+"',"+price+",'Available')";
//		stmt.executeQuery(sql);	
		
//		<PreparedStatement to execute a query>
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(MYSEQ.NEXTVAL,?,?,?,'Available')";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, make);
		ps.setString(2, info);
		ps.setDouble(3, price);
		ps.executeUpdate();
		
		LogThis.LogIt("info", "Car "+make+ "'s information has been inserted.");
		
	}


	@Override
	public List<Car> getCarList() throws SQLException {
		// TODO Auto-generated method stub
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR");
		Car c = null;
		while(rs.next()) {
			c = new Car(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
			carList.add(c);
		}
		return carList;
	}

    
    @Override
	public void updateCarList(int id) throws SQLException{
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "UPDATE CAR SET CAR_STATUS = 'Pending' WHERE CAR_ID = "+id+"";
		stmt.executeQuery(sql);    	
	}


	@Override
	public void deleteCarList() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Please input the removing Car ID:");
		int id = scan.nextInt();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM CAR WHERE CAR_ID = "+id+"";
		stmt.executeQuery(sql); 
		System.out.println("Car ID = "+id+" has been successfully removed.");
		LogThis.LogIt("info", "Car ID "+id+ " 's informations has been deleted.");
		
	}


	@Override
	public List<CarCustomerMenu> getAvailable() throws SQLException{
		// TODO Auto-generated method stub
		List<CarCustomerMenu> carList = new ArrayList<CarCustomerMenu>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CAR_ID,CAR_NAME,CAR_INFORMATION,CAR_PRICE FROM CAR WHERE CAR_STATUS='Available'");
		CarCustomerMenu c = null;
		while(rs.next()) {
			c = new CarCustomerMenu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			carList.add(c);
		}
		return carList;
	}



    
    

}
