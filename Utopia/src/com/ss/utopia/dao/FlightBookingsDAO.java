/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.FlightBookings;

/**
 * @author luisherre
 *
 */
public class FlightBookingsDAO extends BaseDAO<FlightBookings> {

	public FlightBookingsDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<FlightBookings> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBookings> bookings = new ArrayList<>();
		while (rs.next()) {
			BookingDAO bdao = new BookingDAO(conn);
			FlightDAO fdao = new FlightDAO(conn);
			FlightBookings booking = new FlightBookings();
			booking.setBooking(
					bdao.read("select * from booking where id = ?", new Object[] { rs.getInt("booking_id") }).get(0));
			booking.setFlight(
					fdao.read("select * from flight where id = ?", new Object[] { rs.getInt("flight_id") }).get(0));
		}
		return bookings;
	}

	public void createFlightBookings(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		save("insert into flight_bookings (flight_id, booking_id) values (?,?)",
				new Object[] { flightBooking.getFlight().getId(), flightBooking.getBooking().getId() });
	}

	public List<FlightBookings> readAllFlightBookings() throws ClassNotFoundException, SQLException {
		return read("select * from flight_bookings", null);
	}

	public void deleteFlightBooking(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight_bookings where flight_id = ? and booking_id = ?",
				new Object[] { flightBooking.getFlight().getId(), flightBooking.getBooking().getId() });
	}
	
	public void deleteFlightBookingByBookingId(int bookingId) throws ClassNotFoundException, SQLException {
		save("DELETE FROM flight_bookings where booking_id = ?",
				new Object[] { bookingId });
	}

}
