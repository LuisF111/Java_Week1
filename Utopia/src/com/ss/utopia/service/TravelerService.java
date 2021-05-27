/**
 * 
 */
package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.FlightBookingsDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightBookings;
import com.ss.utopia.entity.Passenger;

/**
 * @author luisherre
 *
 */
public class TravelerService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public Passenger readPassengerById(int id) throws SQLException {
		Connection conn = null;
		Passenger member = new Passenger();
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			member = pdao.readPassengerById(id).get(0);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return member;
	}
	
	public List<Flight> readAllFlights() throws SQLException {
		Connection conn = null;
		List<Flight> flights = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flights = fdao.readAllFlights();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return flights;
	}
	
	public void createBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bdao.createBooking(booking);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}
	
	public void createFlightBookings(FlightBookings flightBooking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookingsDAO fdao = new FlightBookingsDAO(conn);
			fdao.createFlightBookings(flightBooking);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}
	
	public void reserveSeat(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flight.setReservedSeats(flight.getReservedSeats() + 1);
			fdao.updateFlight(flight);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public void unreserveSeat(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			flight.setReservedSeats(flight.getReservedSeats() - 1);
			fdao.updateFlight(flight);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public Booking readBooking(Booking booking) throws SQLException {
		Connection conn = null;
		Booking bookingWithId = new Booking();
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bookingWithId = bdao.readBooking(booking).get(0);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bookingWithId;
	}
	
	public void updateBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bdao.updateBooking(booking);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public void deleteFlightBooking(int bookingId) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightBookingsDAO fdao = new FlightBookingsDAO(conn);
			fdao.deleteFlightBookingByBookingId(bookingId);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
}
