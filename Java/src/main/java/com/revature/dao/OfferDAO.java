package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Offer;
import com.revature.beans.OfferPayment;
import com.revature.beans.OfferPending;
import com.revature.beans.OfferRemain;


public interface OfferDAO {
	
	public int insertOffer(String username) throws SQLException;
	public List<Offer> getOfferList(String username) throws SQLException;
	public List<OfferRemain> remainPayment(String username) throws SQLException;
	public List<OfferPending> getPendingOffer() throws SQLException;
	public List<OfferPayment> getCustomerPayment() throws SQLException;
	public void acceptOffer() throws SQLException;
	public void rejectOffer() throws SQLException;
	public void deleteOffer() throws SQLException;

}
