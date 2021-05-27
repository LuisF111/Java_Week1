///**
// * 
// */
//package com.ss.utopia.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Scanner;
//
///**
// * @author luisherre
// *
// */
//public class ReadRoutesByAirport {
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
//		System.out.println("Enter Origin ID to search >");
//		PreparedStatement pstmt = conn.prepareStatement("select * from route where origin_id = ?");
//		Scanner scan = new Scanner(System.in);
//		pstmt.setString(1, scan.nextLine());
//		
//		// execution
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()) {
//			System.out.println("Route ID: " + rs.getInt("id"));
//			System.out.println("Origin ID: " + rs.getString("origin_id"));
//			System.out.println("Destination ID: " + rs.getString("destination_id"));
//		}
//
//	}
//
//}
