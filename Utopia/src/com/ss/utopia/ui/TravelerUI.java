/**
 * 
 */
package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightBookings;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.TravelerService;

/**
 * @author luisherre
 *
 */
public class TravelerUI {

	private TravelerService travServ = new TravelerService();
	private Passenger member = new Passenger();
	private FlightBookings memberBooking = new FlightBookings();

	public void authenticateTraveler() {
		System.out.println("Enter your Membership Number: ");
		MainUI.userInput();

		Scanner input = new Scanner(System.in);
		Integer memNum = input.nextInt();

		try {
			member = travServ.readPassengerById(memNum);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Membership Number not found. Try Again.");
			authenticateTraveler();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void travelerMenu() {
		authenticateTraveler();

		System.out.println("1) Book/Cancel a ticket");
		System.out.println("2) Quit");
		MainUI.userInput();

		Scanner input = new Scanner(System.in);
		Integer choice;

		try {
			do {
				choice = input.nextInt();
				switch (choice) {
				case 1:
					bookingMenu();
					return;
				case 2:
					MainUI.mainMenu();
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

	private void bookingMenu() {
		try {
			List<Flight> flights = new ArrayList<Flight>(travServ.readAllFlights());

			int count = 1;
			for (Flight flight : flights) {
				int availSeats = flight.getPlane().getTypeId().getCapacity() - flight.getReservedSeats();
				if (availSeats > 0) {
					String oCode = flight.getRoute().getOrigin().getAirportCode();
					String oCity = flight.getRoute().getOrigin().getCity();
					String dCode = flight.getRoute().getDestination().getAirportCode();
					String dCity = flight.getRoute().getDestination().getCity();
					System.out.println(count + ")" + " " + oCode + ", " + oCity + " -> " + dCode + ", " + dCity);
					count++;
				}
			}
			System.out.println(flights.size() + 1 + ") Quit to Main Menu.");
			MainUI.userInput();

			Scanner input = new Scanner(System.in);
			Integer choice = input.nextInt();

			do {
				if (choice < flights.size() && choice >= 0) {
					bookFlight(flights.get(choice - 1));
				} else if (choice == flights.size() + 1) {
					System.out.println("returning to main menu.");
					MainUI.mainMenu();
					return;
				} else {
					System.out.println("Unkown choice selection, returning to previous menu.");
					travelerMenu();
					return;
				}
			} while (true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void bookFlight(Flight flight) {
		System.out.println("1) View Flight Details");
		System.out.println("2) Comfirm Booking");
		System.out.println("3) Cancel Booking");
		System.out.println("4) Quit");
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
					System.out.println("Confirming Booking Details...\n");
					Booking newBooking = new Booking();
					newBooking.setActive(true);
					Random rnd = new Random();
					int number = rnd.nextInt(999999);

					newBooking.setConfirmationCode(String.format("%06d", number));
					newBooking.setActive(true);

					travServ.createBooking(newBooking);
					Booking newBookingWithId = travServ.readBooking(newBooking);

					FlightBookings newFlightBooking = new FlightBookings();
					newFlightBooking.setBooking(newBookingWithId);
					newFlightBooking.setFlight(flight);
					travServ.createFlightBookings(newFlightBooking);

					travServ.reserveSeat(flight);

					memberBooking.setBooking(newBookingWithId);
					memberBooking.setFlight(flight);
					return;
				case 3:
					cancelBooking(flight);
				case 4:
					MainUI.mainMenu();
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

	private void cancelBooking(Flight flight) {
		try {
			member.getBooking().setActive(false);
			travServ.updateBooking(member.getBooking());

			travServ.unreserveSeat(flight);

			travServ.deleteFlightBooking(member.getBooking().getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
