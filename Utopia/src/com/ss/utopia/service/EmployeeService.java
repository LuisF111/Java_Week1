package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.entity.Flight;

public class EmployeeService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
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
	
	public void updateFlight(Flight newFlight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			rdao.updateRoute(newFlight.getRoute());
			FlightDAO fdao = new FlightDAO(conn);
			fdao.updateFlight(newFlight);
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

}
