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

/**
 * @author luisherre
 *
 */
public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Booking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Booking> list = new ArrayList<>();
		while (rs.next()) {
			Booking obj = new Booking();
			obj.setActive(rs.getBoolean("is_active"));
			obj.setConfirmationCode(rs.getString("confirmation_code"));
			obj.setId(rs.getInt("id"));
			list.add(obj);
		}
		return list;
	}

	public void createBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking (is_active, confirmation_code) VALUES (?,?)",
				new Object[] { booking.isActive(), booking.getConfirmationCode() });
	}

	public List<Booking> readAllBookings() throws ClassNotFoundException, SQLException {
		return read("select * from booking", null);
	}

	public List<Booking> readBooking(Booking booking) throws ClassNotFoundException, SQLException {
		return read("select * from booking where confirmation_code = ?",
				new Object[] { booking.getConfirmationCode() });
	}

	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("UPDATE booking set is_active = ?, confirmation_code = ? where id = ?",
				new Object[] { booking.isActive(), booking.getConfirmationCode(), booking.getId() });
	}

	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("delete from booking where id = ?", new Object[] { booking.getId() });
	}

}
