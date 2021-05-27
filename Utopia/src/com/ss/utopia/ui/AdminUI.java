/**
 * 
 */
package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.AdminService;

/**
 * @author luisherre
 *
 */
public class AdminUI {
	private AdminService adminServ = new AdminService();

	public void adminMenu() {
		System.out.println("Administrator Management Console\n");
		System.out.println("1) Manage Airports");
		System.out.println("2) Quit to previous");
		MainUI.userInput();

		Scanner input = new Scanner(System.in);
		Integer choice;

		try {
			do {
				choice = input.nextInt();
				switch (choice) {
				case 1:
					adminAirports();
					return;
				case 2:
					MainUI.mainMenu();
					return;
				default:
					System.out.println("Invalid selection, returning to main menu.");
					MainUI.mainMenu();
					return;
				}
			} while (true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void adminAirports() {
		try {
			List<Airport> ports = new ArrayList<Airport>(adminServ.readAllAirports());

			int count = 1;
			for (Airport port : ports) {
				String pCode = port.getAirportCode();
				String pCity = port.getCity();
				System.out.println(count + ")" + " " + pCode + ", " + pCity);
				count++;
			}
			System.out.println(ports.size() + 1 + ") Create Airport.");
			System.out.println(ports.size() + 2 + ") Quit to Main Menu.");
			MainUI.userInput();

			Scanner input = new Scanner(System.in);
			Integer choice = input.nextInt();

			do {
				if (choice <= ports.size() && choice >= 0) {
					adminAirport(ports.get(choice - 1));
				} else if (choice == ports.size() + 1) {
					createAirport();
					adminAirports();
					return;
				} else if (choice == ports.size() + 2) {
					System.out.println("returning to main menu.");
					MainUI.mainMenu();
					return;
				} else {
					System.out.println("Unkown choice selection, returning to previous menu.");
					adminMenu();
					return;
				}
			} while (true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void adminAirport(Airport port) {
		System.out.println("1) View more details about the Airport");
		System.out.println("2) Update details of the Airport");
		System.out.println("3) Delete Airport");
		System.out.println("4) Quit to previous");
		MainUI.userInput();

		Scanner input = new Scanner(System.in);
		Integer choice;

		try {
			do {
				choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.println(port.toString());
					return;
				case 2:
					updateAirport(port);
					adminAirports();
					return;
				case 3:
					deleteAirport(port);
					adminAirports();
					return;
				case 4:
					adminAirports();
					return;
				default:
					System.out.println("Invalid selection, returning to main menu.");
					MainUI.mainMenu();
					return;
				}
			} while (true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAirport(Airport port) {
		Scanner scan = new Scanner(System.in);
		String empInput = new String();

		System.out.println("Please enter new Airport code and City [ XXX,cityname ] or enter N/A for no change: ");
		empInput = scan.nextLine();

		if (!empInput.equalsIgnoreCase("n/a")) {
			Airport newPort = new Airport();
			String[] inputArr = empInput.split(",");
			try {
				if (inputArr[0].length() != 3 || inputArr[0].isEmpty()) {
					throw new Exception();
				} else if (inputArr[0].length() > 45 || inputArr[1].isEmpty()) {
					throw new Exception();
				}

				newPort.setAirportCode(inputArr[0]);
				newPort.setCity(inputArr[1]);

				adminServ.updateAirport(newPort);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (empInput.equalsIgnoreCase("quit")) {
			adminAirports();
		}
	}

	public Airport updateAirport(String vals) {
		Airport port = new Airport();
		String[] inputArr = vals.split(",");
		try {
			if (inputArr[0].length() != 3 || inputArr[0].isEmpty()) {
				throw new Exception();
			} else if (inputArr[0].length() > 45 || inputArr[1].isEmpty()) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		port.setAirportCode(inputArr[0]);
		port.setCity(inputArr[1]);

		return port;
	}

	public void createAirport() {
		Scanner scan = new Scanner(System.in);
		String empInput = new String();

		System.out.println("Please enter new Airport code and City [ XXX,cityname ]");
		empInput = scan.nextLine();

		if (!empInput.equalsIgnoreCase("n/a")) {
			Airport newPort = new Airport();
			String[] inputArr = empInput.split(",");
			try {
				if (inputArr[0].length() != 3 || inputArr[0].isEmpty()) {
					throw new Exception();
				} else if (inputArr[0].length() > 45 || inputArr[1].isEmpty()) {
					throw new Exception();
				}

				newPort.setAirportCode(inputArr[0]);
				newPort.setCity(inputArr[1]);

				adminServ.createAirport(newPort);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (empInput.equalsIgnoreCase("quit")) {
			adminAirports();
		}
	}

	public void deleteAirport(Airport port) {
		try {
			adminServ.deleteAirport(port);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}