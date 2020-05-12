package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.revature.beans.Offer;
import com.revature.beans.OfferPayment;
import com.revature.beans.OfferPending;
import com.revature.beans.OfferRemain;
import com.revature.dao.OfferDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class OfferDAOImpl implements OfferDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	static Scanner scan = new Scanner(System.in);
	static CarDAOImpl cdi = new CarDAOImpl();
	static OfferDAOImpl odi = new OfferDAOImpl();
	
	@Override
	public int insertOffer(String username) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		System.out.println("Please input the Car ID that you want to purchase:");
		int id = scan.nextInt();
		
		ResultSet rss = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE CUSTOMER_USERNAME = '"+username+"'");
		if(rss.next() == true) {
			int cuid = rss.getInt(1);
			String name = rss.getString(4);
		    ResultSet rs = stmt.executeQuery("SELECT * FROM CAR WHERE CAR_ID = '"+id+"' AND CAR_STATUS = 'Available'");
			if(rs.next() == true)  { 
				LogThis.LogIt("info", "A New Offer for CAR ID = "+rs.getInt(1)+ " are waiting for your approval.");
				String sql ="INSERT INTO OFFER VALUES(MYSEQ4.NEXTVAL" + ",'"+id+"','"+cuid+"','"+ rs.getString(2)+"',"+ rs.getDouble(4)+",'"+name+"','Pending',0,0,0)";
				stmt.executeQuery(sql);
			} else {
				System.out.println("The Car ID you input is not available");
				odi.insertOffer(username);
			}
		}
		System.out.println("Thank you! Please wait 3-5 business days to be appoved!");
		return id;
	}

	@Override
	public List<Offer> getOfferList(String username) throws SQLException {
		// TODO Auto-generated method stub
		List<Offer> offerList = new ArrayList<Offer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rss = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE CUSTOMER_USERNAME = '"+username+"'");
		if(rss.next() == true) {
			int cuid = rss.getInt(1);
			ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE CUSTOMER_ID = "+cuid+" AND OFFER_STATUS = 'Proved'");
		    Offer o = null;
		    while(rs.next()) {
			    o = new Offer(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
			    offerList.add(o);
		    }
		}
		return offerList;
	}

	@Override
	public void acceptOffer() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		System.out.println("Enter offer ID to approve:");
		int offerid = scan.nextInt();
		//update OFFER table;
		String sql = "UPDATE OFFER SET OFFER_STATUS = 'Proved' WHERE OFFER_ID = "+offerid+"";
		stmt.executeQuery(sql); 
		
		//update CAR table;
		ResultSet rss = stmt.executeQuery("SELECT * FROM OFFER WHERE OFFER_ID = "+offerid+"");
		if(rss.next() == true) {
			//update CAR table;
			int carid = rss.getInt(2);
			LogThis.LogIt("info", "The CAR ID :"+rss.getInt(2)+ ", has been approved.");
			String sql2 ="UPDATE CAR SET CAR_STATUS = 'Sold' WHERE CAR_ID = "+carid+"";
			stmt.executeQuery(sql2);	
		} 
	    else {
			System.out.println("The OFFER ID you input is not available");
			odi.acceptOffer();
		}
		
		//update offer table;
		ResultSet rsss = stmt.executeQuery("SELECT * FROM OFFER WHERE OFFER_ID = "+offerid+"");
		if(rsss.next() == true) {
		double a = rsss.getDouble(5);
		double b = a*1.02/24;
		double c = a*1.03/36;
		String sql3 ="UPDATE OFFER SET CAR_REMAIN = "+a+", MONTHLY24 = "+b+", MONTHLY36 = "+c+" WHERE OFFER_ID = "+offerid+"";
		stmt.executeQuery(sql3);
		}
		System.out.println("The Offer ID "+offerid+" has been approved");
	}

	@Override
	public void rejectOffer() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		System.out.println("Enter offer ID to deny:");
		int offerid = scan.nextInt();
		//update OFFER table;
		String sql = "UPDATE OFFER SET OFFER_STATUS = 'Denied' WHERE OFFER_ID = "+offerid+"";
		stmt.executeQuery(sql); 
		//update CAR table;
		ResultSet rss = stmt.executeQuery("SELECT * FROM OFFER WHERE OFFER_ID = "+offerid+"");
		if(rss.next() == true) {
			LogThis.LogIt("info", "The CAR ID :"+rss.getInt(2)+ ", has been denied.");
			int carid = rss.getInt(2);
			String sql2 ="UPDATE CAR SET CAR_STATUS = 'Available' WHERE CAR_ID = "+carid+"";
			stmt.executeQuery(sql2);
		} else {
			System.out.println("The OFFER ID you input is not available");
			odi.rejectOffer();
		}
		System.out.println("The Offer ID "+offerid+" has been denid. Back to the lot.");
	}
		

	@Override
	public List<OfferRemain> remainPayment(String username) throws SQLException {
		// TODO Auto-generated method stub
		List<OfferRemain> balance = new ArrayList<OfferRemain>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rss = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE CUSTOMER_USERNAME = '"+username+"'");
		if(rss.next() == true) {
			int cuid = rss.getInt(1);
			ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE CUSTOMER_ID = "+cuid+" AND OFFER_STATUS = 'Sold'");
		    OfferRemain o = null;
		    while(rs.next()) {
			    o = new OfferRemain(rs.getString(6),rs.getString(4),rs.getDouble(5),rs.getDouble(8),rs.getDouble(9),rs.getDouble(10));
			    balance.add(o);
		    }
		}
		return balance;
	}

	@Override
	public List<OfferPending> getPendingOffer() throws SQLException {
		// TODO Auto-generated method stub
		List<OfferPending> pending = new ArrayList<OfferPending>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE OFFER_STATUS = 'Pending'");
		//ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER");
		OfferPending o = null;
	    while(rs.next()) {
		    o = new OfferPending(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
		    pending.add(o);	
		}
		return pending;
	}

	@Override
	public void deleteOffer() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Please input the removing Offer ID:");
		int id = scan.nextInt();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM OFFER WHERE OFFER_ID = "+id+"";
		stmt.executeQuery(sql);  
		
	}

	@Override
	public List<OfferPayment> getCustomerPayment() throws SQLException {
		// TODO Auto-generated method stub
		List<OfferPayment> payment = new ArrayList<OfferPayment>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFER WHERE OFFER_STATUS = 'Proved'");
		OfferPayment o = null;
	    while(rs.next()) {
	    	double pay = rs.getDouble(5) - rs.getDouble(8);
		    o = new OfferPayment(rs.getInt(1),rs.getInt(3),rs.getString(6),rs.getInt(2),rs.getString(4),rs.getDouble(5),rs.getDouble(8), pay);
		    payment.add(o);	
		}
		return payment;
	}

}
