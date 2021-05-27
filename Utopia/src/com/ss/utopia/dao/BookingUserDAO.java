/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingUser;

/**
 * @author luisherre
 *
 */
public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> list = new ArrayList<>();
		while (rs.next()) {
			BookingUser obj = new BookingUser();
			BookingDAO bdao = new BookingDAO(conn);
			UserDAO udao = new UserDAO(conn);

			obj.setUserId(udao.read("select * from user where id = ?", new Object[] { rs.getInt("user_id") }).get(0));
			obj.setBooking(bdao.read("select * from booking where id = ?", new Object[] {rs.getInt("booking_id")}).get(0));

			list.add(obj);
		}
		return list;
	}

	public void createBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_user (booking_id, user_id) VALUES (?,?)",
				new Object[] { bookingUser.getBooking(), bookingUser.getUserId() });
	}

	public List<BookingUser> readAllBookingUsers() throws ClassNotFoundException, SQLException {
		return read("select * from booking_user", null);
	}

	public void updateBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_user booking_id = ? where user_id = ?",
				new Object[] { bookingUser.getBooking(), bookingUser.getUserId() });
	}

	public void deleteBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_user where user_id = ?", new Object[] { bookingUser.getUserId() });
	}

}
