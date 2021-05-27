/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Route;

/**
 * @author luisherre
 *
 */
public class RouteDAO extends BaseDAO<Route> {

	public RouteDAO(Connection conn) {
		super(conn);
	}

	public void createRoute(Route route) throws ClassNotFoundException, SQLException {
		save("insert into route (origin_id,destination_id) values (?,?)",
				new Object[] { route.getOrigin().getAirportCode(), route.getDestination().getAirportCode() });
	}

	public List<Route> readAllRoutes() throws ClassNotFoundException, SQLException {
		return read("select * from route", null);
	}

	public List<Route> readAllRoutesByAirport(String airportCode) throws ClassNotFoundException, SQLException {
		return read("select * from route where origin_id = ? or destination_id = ?",
				new Object[] { airportCode, airportCode });
	}

	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("update route set origin_id = ?, destination_id = ? where id = ?", new Object[] {
				route.getOrigin().getAirportCode(), route.getDestination().getAirportCode(), route.getId() });
	}

	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		save("delete from route where id = ?", new Object[] { route.getId() });
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		while (rs.next()) {
			Route route = new Route();
			route.setId(rs.getInt("id"));
			route.getOrigin().setAirportCode(rs.getString("origin_id"));
			route.getDestination().setAirportCode(rs.getString("destination_id"));
			
			AirportDAO adao = new AirportDAO(conn);
			route.getOrigin().setCity(adao.read("select * from airport where iata_id = ?",
					new Object[] { route.getOrigin().getAirportCode() }).get(0).getCity());
			route.getDestination().setCity(adao.read("select * from airport where iata_id = ?",
					new Object[] { route.getDestination().getAirportCode() }).get(0).getCity());
			
			routes.add(route);
		}
		return routes;
	}

}
