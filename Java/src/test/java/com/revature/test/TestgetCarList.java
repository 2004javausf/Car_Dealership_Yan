package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.daoimpl.CarDAOImpl;


class TestgetCarList {

	@Test
	void test() {
		CarDAOImpl cdi = new CarDAOImpl();
		
		try {
			cdi.insertCar();;
			System.out.println(cdi.getCarList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assertEquals("hello", cdi.toString());
	}

}
