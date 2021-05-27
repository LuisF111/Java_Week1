///**
// * 
// */
//package com.ss.utopia.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// * @author luisherre
// *
// */
//public class ReadRoutes {
//
//	private static final String driver = "com.mysql.cj.jdbc.Driver";
//	private static final String url = "jdbc:mysql://localhost:3306/utopia";
//	private static final String username = "utopiadev";
//	private static final String password = "utopiadb123";
//	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		// register driver
//		Class.forName(driver);
//		
//		// connection
//		Connection conn = DriverManager.getConnection(url, username, password);
//		
//		// statement
//		Statement stmt = conn.createStatement();
//		String query = "select * from route";
//		
//		// execution
//		ResultSet rs = stmt.executeQuery(query);
//		while(rs.next()) {
//			System.out.println("Route ID: " + rs.getInt("id"));
//			System.out.println("Origin ID: " + rs.getString("origin_id"));
//			System.out.println("Destination ID: " + rs.getString("destination_id"));
//		}
//
//	}
//
//}
