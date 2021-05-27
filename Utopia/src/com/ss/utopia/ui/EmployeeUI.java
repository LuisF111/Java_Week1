package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.EmployeeService;

public class EmployeeUI {

	private EmployeeService empServ = new EmployeeService();

	public void employeeMenu() {
		System.out.println("1) Enter Flights you manage");
		System.out.println("2) Quit to previous");
		MainUI.userInput();

		Scanner input = new Scanner(System.in);
		Integer choice;

		try {
			do {
				choice = input.nextInt();
				switch (choice) {
				case 1:
					manageFlights();
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

	public void manageFlights() {
		try {
			List<Flight> flights = new ArrayList<Flight>(empServ.readAllFlights());

			int count = 1;
			for (Flight flight : flights) {
				String oCode = flight.getRoute().getOrigin().getAirportCode();
				String oCity = flight.getRoute().getOrigin().getCity();
				String dCode = flight.getRoute().getDestination().getAirportCode();
				String dCity = flight.getRoute().getDestination().getCity();
				System.out.println(count + ")" + " " + oCode + ", " + oCity + " -> " + dCode + ", " + dCity);
				count++;
			}
			System.out.println(flights.size() + 1 + ") Quit to Main Menu.");
			MainUI.userInput();

			Scanner input = new Scanner(System.in);
			Integer choice = input.nextInt();

			do {
				if (choice <= flights.size() && choice >= 0) {
					manageFlight(flights.get(choice - 1));
				} else if (choice == flights.size() + 1) {
					System.out.println("returning to main menu.");
					MainUI.mainMenu();
					return;
				} else {
					System.out.println("Unkown choice selection, returning to previous menu.");
					employeeMenu();
					return;
				}
			} while (true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void manageFlight(Flight flight) {
		System.out.println("1) View more details about the flight");
		System.out.println("2) Update details of the flight");
		System.out.println("3) Add seats to Flight");
		System.out.println("4) Quit to previous");
		MainUI.userInput();

		Scanner input = new Scanner(System.in);
		Integer choice;

		try {
			do {
				choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.println(flight.toString());
					return;
				case 2:
					updateFlight(flight);
					manageFlight(flight);
					return;
				case 3:
					updateSeats(flight);
					manageFlight(flight);
					return;
				case 4:
					manageFlights();
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

	public void updateFlight(Flight flight) {
		System.out.println("You have chosen to update the Flight with Flight Id: " + flight.getId()
				+ "\nFlight Origin: " + flight.getRoute().getOrigin().toString() + "\nFlight Destination: "
				+ flight.getRoute().getDestination().toString() + ". \n"
				+ "Enter ‘quit’ at any prompt to cancel operation\n" + "");

		Scanner scan = new Scanner(System.in);
		String empInput = new String();

		System.out.println("Please enter new Origin Airport and City [ XXX,cityname ] or enter N/A for no change: ");
		empInput = scan.nextLine();
		if (!empInput.equalsIgnoreCase("n/a")) {
			flight.getRoute().setOrigin(updateAirport(empInput));
		} else if (empInput.equalsIgnoreCase("quit")) {
			manageFlight(flight);
		}

		System.out
				.println("Please enter new Detination Airport and City [ XXX,cityname ] or enter N/A for no change: ");
		empInput = scan.nextLine();
		if (!empInput.equalsIgnoreCase("n/a")) {
			flight.getRoute().setDestination(updateAirport(empInput));
		} else if (empInput.equalsIgnoreCase("quit")) {
			manageFlight(flight);
		}

		System.out.println("Please enter new Departure Date [ YYYY-MM-DD ] or enter N/A for no change: ");
		empInput = scan.next();
		if (!empInput.equalsIgnoreCase("n/a")) {
			flight.setDepatureDateTime(updateDate(flight.getDepatureDateTime(), empInput));
		} else if (empInput.equalsIgnoreCase("quit")) {
			manageFlight(flight);
		}

		System.out.println("Please enter new Departure Time [ HH:mm:ss ] or enter N/A for no change: ");
		empInput = scan.next();
		if (!empInput.equalsIgnoreCase("n/a")) {
			flight.setDepatureDateTime(updateTime(flight.getDepatureDateTime(), empInput));
		} else if (empInput.equalsIgnoreCase("quit")) {
			manageFlight(flight);
		}

		try {
			empServ.updateFlight(flight);
		} catch (SQLException e) {
			System.err.println("An error occurred while updating a Flight on MySQL.");
			e.printStackTrace();
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

	public String updateDate(String currDateTime, String newDate) {
		String updatedDate = null;
		try {
			if (newDate.length() != 10 || newDate.isEmpty()) {
				throw new Exception();
			} else {
				String[] dateTime = currDateTime.split(" ");
				updatedDate = newDate + " " + dateTime[1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updatedDate;
	}

	public String updateTime(String currDateTime, String newTime) {
		String updatedTime = null;
		try {
			if (newTime.length() != 8 || newTime.isEmpty()) {
				throw new Exception("Incorrect Time format");
			} else {
				String[] dateTime = currDateTime.split(" ");
				updatedTime = dateTime[0] + " " + newTime;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updatedTime;
	}

	public void updateSeats(Flight flight) {
		System.out.println("You have chosen to update the number of seats in Flight with Flight Id: " + flight.getId()
				+ "\nFlight Origin: " + flight.getRoute().getOrigin().toString() + "\nFlight Destination: "
				+ flight.getRoute().getDestination().toString() + ". \n\n");

		Scanner scan = new Scanner(System.in);
		int empInput;

		int availSeats = flight.getPlane().getTypeId().getCapacity() - flight.getReservedSeats();
		System.out.println("Available number of Seats: " + availSeats);
		empInput = scan.nextInt();

		while (empInput > availSeats || empInput < 0) {
			System.out.println("Cannot Reserve that number of seats. Try again.");
			System.out.println("Available number of Seats: " + availSeats);
			empInput = scan.nextInt();
		}

		int updatedReservedSeats = flight.getReservedSeats() + empInput;
		flight.setReservedSeats(updatedReservedSeats);

		try {
			empServ.updateFlight(flight);
		} catch (SQLException e) {
			System.err.println("An error occurred while updating Reserverd Seats on MySQL.");
			e.printStackTrace();
		}

	}

}
