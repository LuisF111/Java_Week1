/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.User;

/**
 * @author luisherre
 *
 */
public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<>();
		while (rs.next()) {
			User obj = new User();

			obj.setId(rs.getInt("id"));
			obj.setGivenName(rs.getString("given_name"));
			obj.setFamilyName(rs.getString("family_name"));
			obj.setUsername(rs.getString("username"));
			obj.setEmail(rs.getString("email"));
			obj.setPassword(rs.getString("password"));
			obj.setPhone(rs.getString("phone"));

			UserRoleDAO urdao = new UserRoleDAO(this.conn);
			obj.setRole(urdao.read("select * from user_role where id = ?", rs.getInt("role_id")).get(0));

			list.add(obj);
		}
		return list;
	}

	public void createUser(User user) throws ClassNotFoundException, SQLException {
		save("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone) VALUES (?,?,?,?,?,?,?)",
				new Object[] { user.getRole(), user.getGivenName(), user.getFamilyName(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone() });
	}

	public List<User> readAllUsers() throws ClassNotFoundException, SQLException {
		return read("select * from user", null);
	}

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		save("UPDATE user set role_id = ?, given_name = ?, family_name = ?, username = ?, email = ?, password = ?, phone = ? where id = ?",
				new Object[] { user.getRole(), user.getGivenName(), user.getFamilyName(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPassword(), user.getId()});
	}

	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		save("DELETE FROM user where id = ?", new Object[] { user.getId() });
	}

}
