/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingAgent;

/**
 * @author luisherre
 *
 */
public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> list = new ArrayList<>();
		while (rs.next()) {
			BookingAgent obj = new BookingAgent();
			BookingDAO bdao = new BookingDAO(conn);
			UserDAO udao = new UserDAO(conn);

			obj.setAgentId(udao.read("select * from user where id = ?", new Object[] { rs.getInt("agent_id") }).get(0));
			obj.setBooking(
					bdao.read("select * from booking where id = ?", new Object[] { rs.getInt("booking_id") }).get(0));

			list.add(obj);
		}
		return list;
	}

	public void createBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_agent (booking_id, agent_id) VALUES (?,?)",
				new Object[] { bookingAgent.getBooking(), bookingAgent.getAgentId() });
	}

	public List<BookingAgent> readAllBookingAgent() throws ClassNotFoundException, SQLException {
		return read("select * from booking_agent", null);
	}

	public void updateBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("UPDATE booking_agent booking_id = ? where agent_id = ?",
				new Object[] { bookingAgent.getBooking(), bookingAgent.getAgentId() });
	}

	public void deleteBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_agent where agent_id = ?", new Object[] { bookingAgent.getAgentId() });
	}

}
