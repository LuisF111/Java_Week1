/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingGuest;

/**
 * @author luisherre
 *
 */
public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> list = new ArrayList<>();
		while (rs.next()) {
			BookingGuest obj = new BookingGuest();
			BookingDAO bdao = new BookingDAO(conn);
			obj.setBooking(
					bdao.read("select * from booking where id = ?", new Object[] { rs.getInt("booking_id") }).get(0));
			obj.setEmail(rs.getString("contact_email"));
			obj.setPhone(rs.getString("contact_phone"));

			list.add(obj);
		}
		return list;
	}

	public void createBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("insert into booking_guest (booking_id, contact_email, contact_phone) values (?,?,?)",
				new Object[] { bookingGuest.getBooking(), bookingGuest.getEmail(), bookingGuest.getPhone() });
	}

	public List<BookingGuest> readAllBookingGuests() throws ClassNotFoundException, SQLException {
		return read("select * from booking_guest", null);
	}

	public void updateBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("update booking_guest set contact_email = ?, contact_phone = ? where booking_id = ?",
				new Object[] { bookingGuest.getEmail(), bookingGuest.getPhone(), bookingGuest.getBooking() });
	}

	public void deleteGuestBooking(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("delete from booking_guest where booking_id = ?", new Object[] { bookingGuest.getBooking() });
	}

}
