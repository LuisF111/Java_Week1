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
// * 
// * Same process for Update and Delete.
// * 
// * @author luisherre
// *
// */
//public class SaveRoutes {
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
//		PreparedStatement pstmt = conn.prepareStatement
//				("insert into route (origin_id,destination_id) values (?,?)");
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter Origin ID to Insert: ");
//		pstmt.setString(1, scan.nextLine());
//		System.out.println("Enter Destination ID to Insert: ");
//		pstmt.setString(2, scan.nextLine());
//		
//		// execution
//		pstmt.executeUpdate();
//
//	}
//
//}
