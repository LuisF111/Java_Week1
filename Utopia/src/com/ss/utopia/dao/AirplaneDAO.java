/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airplane;
import com.ss.utopia.entity.AirplaneType;

/**
 * @author luisherre
 *
 */
public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> planes = new ArrayList<>();
		while (rs.next()) {
			Airplane plane = new Airplane();
			plane.setId(rs.getInt("id"));

			AirplaneTypeDAO planeTypeDAO = new AirplaneTypeDAO(conn);
			AirplaneType planeType = planeTypeDAO
					.read("select * from airplane_type where id = ?", new Object[] { rs.getInt("type_id") }).get(0);
			plane.setTypeId(planeType);

			planes.add(plane);
		}
		return planes;
	}

	public void createAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airplane (type_id) VALUES (?)", new Object[] { airplane.getTypeId() });
	}

	public List<Airplane> readAllAirplanes() throws ClassNotFoundException, SQLException {
		return read("select * from airplane", null);
	}

	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane set type_id = ? where id = ?", new Object[] { airplane.getTypeId(), airplane.getId() });
	}

	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("DELETE FROM airplane where id = ?", new Object[] { airplane.getId() });
	}

}
