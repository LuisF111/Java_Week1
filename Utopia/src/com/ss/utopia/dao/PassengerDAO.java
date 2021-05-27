/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Passenger;

/**
 * @author luisherre
 *
 */
public class PassengerDAO extends BaseDAO<Passenger> {

	public PassengerDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setAddress(rs.getString("address"));

			BookingDAO bdao = new BookingDAO(conn);
			Booking booking = bdao.read("select * from booking where id = ?", new Object[] { rs.getInt("booking_id") })
					.get(0);

			passenger.setBooking(booking);
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setDateOfBirth(rs.getDate("dob"));
			passenger.setGender(rs.getString("gender"));

			passengers.add(passenger);
		}
		return passengers;
	}

	public void createPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("INSERT INTO passenger (booking_id, given_name, family_name, dob, gender, address) VALUES (?,?,?,?,?,?)",
				new Object[] { passenger.getBooking(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDateOfBirth(), passenger.getGender(), passenger.getAddress() });
	}

	public List<Passenger> readAllPassengers() throws ClassNotFoundException, SQLException {
		return read("select * from passenger", null);
	}
	
	public List<Passenger> readPassengerById(int id) throws ClassNotFoundException, SQLException {
		return read("select * from passenger where id = ?", new Object[] { id });
	}

	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("update passenger set booking_id = ?, given_name = ?, family_name= ?, dob = ?, gender = ?, address = ? where id = ?",
				new Object[] { passenger.getBooking(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDateOfBirth(), passenger.getGender(), passenger.getAddress(), passenger.getId() });
	}

	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("DELETE FROM passenger where id = ?", new Object[] { passenger.getId() });
	}

}
