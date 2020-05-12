package com.revature.menu;

import java.util.Scanner;

public class StartMenu {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void startMenu() {
		System.out.println("============================");
		System.out.println("Welcome to Valley Road Motors!");
		System.out.println("Please enter a choice:");
		System.out.println("[R]egister a new customer account");
		System.out.println("[C]ustomer Login");
		System.out.println("[E]mployee Login");
		System.out.println("[Q]uit");
		System.out.println("============================");
		String choice = scan.nextLine();
		switch(choice.toLowerCase()) {
		    case "r":
		    	CustomerMenu.registerMenu();
		    	break;
		    case "c":
		    	CustomerMenu.cLoginMenu();
		    	break;
		    case "e":
		    	EmployeeMenu.eLoginMenu();
		    	break;
		    case "q":
		        System.out.println("Thank you for choosing our service. ");
		        break;
		    default:
		        System.out.println("Invalid Input, Try again.");
		        startMenu();
		        break;
		}
	}
	
	
}
