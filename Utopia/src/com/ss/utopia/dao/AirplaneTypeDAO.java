/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class AirplaneTypeDAO extends BaseDAO<AirplaneType>{

	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> types = new ArrayList<>();
		while (rs.next()) {
			AirplaneType type = new AirplaneType();
			type.setType(rs.getInt("id"));
			type.setCapacity(rs.getInt("max_capacity"));
			types.add(type);
		}
		return types;
	}

	public void createAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("INSERT INTO airplane_type (max_capacity) VALUES (?)",
				new Object[] { airplaneType.getCapacity() });
	}
	
	public List<AirplaneType> readAllAirplaneTypes() throws ClassNotFoundException, SQLException {
		return read("select * from airplane_type", null);
	}
	
	public void updateAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("UPDATE airplane_type set max_capacity = ? where id = ?", new Object[] {
				airplaneType.getCapacity(), airplaneType.getType() });
	}
	
	public void deleteAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("DELETE FROM airplane_type where id = ?", new Object[] { airplaneType.getType() });
	}

//	public List<AirplaneType> read(String sql, int type) throws SQLException, ClassNotFoundException {
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, type);
//		return extractData(pstmt.executeQuery());
//		
//	}
	
}
