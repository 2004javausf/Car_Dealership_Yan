package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.OfferDAOImpl;

public class CustomerMenu {
	
	static Scanner scan = new Scanner(System.in);
	static CustomerDAOImpl cudi = new CustomerDAOImpl();
	static CarDAOImpl cdi = new CarDAOImpl();
	static OfferDAOImpl odi = new OfferDAOImpl();
	static String username = null;
	
	public static void registerMenu() {
        
		try {
			cudi.insertCustomer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Would you like to Login? (y/n)");
		String choice = scan.nextLine();
		if(choice.equalsIgnoreCase("y")) {
			try {
				username = cudi.cLogin();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(choice.equalsIgnoreCase("n")) {
			StartMenu.startMenu();
		}else {
			System.out.println("Going back to the main menu.");
			StartMenu.startMenu();;
		}
	}
	
	public static void cLoginMenu() {
		// TODO Auto-generated method stub
		try {
			username = cudi.cLogin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CustomerMenu.customerMenu();
	}	

	public static void customerMenu() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Customer Menu!");
		int option = 0;
		int id = 0;
		do {
			System.out.println("============================");
			System.out.println("Please make a option:");
			System.out.println("1. View the cars on the lot.");
			System.out.println("2. Make an offer for a car.");
			System.out.println("3. View the cars that I own.");
			System.out.println("4. View my remain payments for a car.");
			System.out.println("5. Exit.");
			System.out.println("============================");
			
			option = scan.nextInt();
			switch(option) {
			case 1:
				System.out.println("Welcome to our Car lot!");
				try {
					System.out.println(cdi.getAvailable());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Welcome to our MENU for making a Offer!");
				try {
					id = odi.insertOffer(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					cdi.updateCarList(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 3:
				try {
					System.out.println(odi.getOfferList(username));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println(odi.remainPayment(username));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Thank you for choosing our service. ");
				break;
			default:
		        System.out.println("Invalid Input, Try again.");
				break;
			}
		} while (option!= 5);
		
	}


}
