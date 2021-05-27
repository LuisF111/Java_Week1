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

import com.ss.utopia.entity.User;
import com.ss.utopia.entity.UserRole;

/**
 * @author luisherre
 *
 */
public class UserRoleDAO extends BaseDAO<UserRole>{

	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> list = new ArrayList<>();
		while (rs.next()) {
			UserRole obj = new UserRole();
			obj.setName(rs.getString("name"));
			obj.setId(rs.getInt("id"));
			list.add(obj);
		}
		return list;
	}
	
	public void createUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("INSERT INTO user_role (name) VALUES (?)",
				new Object[] { userRole.getName() });
	}
	
	public List<UserRole> readAllUserRoles() throws ClassNotFoundException, SQLException {
		return read("select * from user_role", null);
	}
	
	public void updateUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("update user_role set name = ? where id = ?", new Object[] {
				userRole.getName(), userRole.getId() });
	}
	
	public void deleteUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("delete from user_role where id = ?", new Object[] { userRole.getId() });
	}

	public List<UserRole> read(String sql, int id) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		return extractData(pstmt.executeQuery());
	}

}
