/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingPayment;

/**
 * @author luisherre
 *
 */
public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> payments = new ArrayList<>();
		while (rs.next()) {
			BookingDAO bdao = new BookingDAO(conn);
			BookingPayment payment = new BookingPayment();

			payment.setBooking(
					bdao.read("select * from booking where id = ?", new Object[] { rs.getInt("booking_id") }).get(0));
			payment.setStripeId(rs.getString("stripe_id"));
			payment.setRefunded(rs.getBoolean("refunded"));

			payments.add(payment);

		}
		return payments;
	}

	public void createBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("INSERT INTO booking_payment (booking_id, stripe_id, refunded) VALUES (?,?,?)", new Object[] {
				bookingPayment.getBooking(), bookingPayment.getStripeId(), bookingPayment.isRefunded() });
	}

	public List<BookingPayment> readAllBookingPayments() throws ClassNotFoundException, SQLException {
		return read("select * from booking_payment", null);
	}

	public void updateBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("update booking_payment set stripe_id = ?, refunded = ? where booking_id = ?", new Object[] {
				bookingPayment.getStripeId(), bookingPayment.isRefunded(), bookingPayment.getBooking() });
	}

	public void deleteBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("DELETE FROM booking_payment where booking_id = ?", new Object[] { bookingPayment.getBooking() });
	}

}
