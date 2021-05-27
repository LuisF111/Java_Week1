/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Flight;

/**
 * @author luisherre
 *
 */
public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> list = new ArrayList<>();
		while (rs.next()) {
			Flight obj = new Flight();

			obj.setId(rs.getInt("id"));
			obj.setDepatureDateTime(rs.getString("departure_time"));
			obj.setReservedSeats(rs.getInt("reserved_seats"));
			obj.setSeatPrice(rs.getFloat("seat_price"));

			RouteDAO rdao = new RouteDAO(conn);
			AirplaneDAO pdao = new AirplaneDAO(conn);
			obj.setRoute(rdao.read("select * from route where id = ?", new Object[] { rs.getInt("route_id") }).get(0));
			obj.setPlane(
					pdao.read("select * from airplane where id = ?", new Object[] { rs.getInt("airplane_id") }).get(0));

			list.add(obj);
		}
		return list;
	}

	public void createFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("insert into flight (route_id, airplane_id, departure_time, reserved_seats, seat_price) values (?,?,?,?,?)",
				new Object[] { flight.getRoute().getId(), flight.getPlane().getId(), flight.getDepatureDateTime(),
						flight.getReservedSeats(), flight.getSeatPrice() });
	}

	public List<Flight> readAllFlights() throws ClassNotFoundException, SQLException {
		return read("select * from flight", null);
	}

	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("update flight set route_id = ?, airplane_id = ?, departure_time = ?, reserved_seats = ?, seat_price = ? where id = ?",
				new Object[] { flight.getRoute().getId(), flight.getPlane().getId(), flight.getDepatureDateTime(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getId() });
	}

	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("delete from flight where id = ?", new Object[] { flight.getId() });
	}

}
