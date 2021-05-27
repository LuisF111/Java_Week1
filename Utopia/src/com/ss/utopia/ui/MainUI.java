/**
 * 
 */
package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Scanner;
/**
 * @author luisherre
 *
 */
public class MainUI {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MainUI.mainMenu();
	}
	
	public static void mainMenu() throws ClassNotFoundException, SQLException {
		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you.");
		System.out.println("1) Employee");
		System.out.println("2) Administrator");
		System.out.println("3) Traveler");
		System.out.println("4) Quit/Exit");
		userInput();
		Scanner input = new Scanner(System.in);
		Integer choice;
		do {
			choice = input.nextInt();
			switch (choice) {
			case 1:
				EmployeeUI empUI = new EmployeeUI();
				empUI.employeeMenu();
				break;
			case 2:
				AdminUI adminUI = new AdminUI();
				adminUI.adminMenu();
				break;
			case 3:
				TravelerUI travUI = new TravelerUI();
				travUI.travelerMenu();
				mainMenu();
				break;
			case 4:
				System.out.println("Quit/Exit");
				break;
			default:
				System.out.println("Invalid selection, returning to main menu.");
				mainMenu();
				break;
			}
		} while (choice != 4);
		System.exit(0);
	}

	public static void userInput() {
		System.out.print("> ");
	}
}
