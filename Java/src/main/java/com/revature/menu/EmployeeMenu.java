package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.CarDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.OfferDAOImpl;

public class EmployeeMenu {
	
	static Scanner scan = new Scanner(System.in);
	static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static CarDAOImpl cdi = new CarDAOImpl();
	static OfferDAOImpl odi = new OfferDAOImpl();
	
	public static void eLoginMenu() {
		System.out.println("Employee Login:");
		try {
			edi.eLogin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeMenu.employeeMenu();
	}

	public static void employeeMenu() {
		System.out.println("Welcome to Employee Menu!");
	int option = 0;
	do {
		System.out.println("============================");
		System.out.println("Please make a option:");
		System.out.println("1. Add a new car to the lot.");
		System.out.println("2. remove a car from the lot.");
		System.out.println("3. Accept or reject a pending offer .");
		System.out.println("4. View customer payments.");
		System.out.println("5. Exit.");
		System.out.println("============================");

		option = scan.nextInt();
		switch(option) {
		case 1:
			System.out.println("Welcome to our MENU for adding a New Car!");
			try {
				cdi.insertCar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Welcome to our MENU for removing Car!");
			try {
				System.out.println(cdi.getCarList());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				cdi.deleteCarList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("View Pending Offers:");
			try {
				System.out.println(odi.getPendingOffer());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			do {
				System.out.println("============================");
				System.out.println("1. Approve Pending Offers.");
				System.out.println("2. Deny Pending Offers.");
				System.out.println("3. Going back to Employee Menu.");
				System.out.println("4. Exit.");
				System.out.println("============================");
				
				option = scan.nextInt();
				switch(option) {
				case 1:
					try {
						odi.acceptOffer();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						odi.rejectOffer();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					EmployeeMenu.employeeMenu();
					break;
				case 4:
					System.out.println("Thank you for choosing our service. ");
					break;
				default:
			        System.out.println("Invalid Input, Try again.");
					break;
				}
			} while (option!=4);
			break;
		case 4:
			System.out.println("View customer payments:");
			try {
				System.out.println(odi.getCustomerPayment());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Thanks for using our services. ");
			System.out.println("\n");
			break;
		default:
			System.out.println("Please make a option from 1-5.");
			break;
		}
	} while (option != 5);
	System.out.println("========================================");
	System.out.println("Good bye!");
	System.out.println("========================================");

	}
}

