package edu.globant.day4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionExample {

	public static void main(String[] args) {
		try {
			String url = "jdbc:mysql://localhost:3306/training";
			String user = "root";
			String password = ""; //set your password here
			Connection conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Connection to MySQL was successful.");
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("Couldn't connect with database.");
			e.printStackTrace(System.out);
		}
	}
}
