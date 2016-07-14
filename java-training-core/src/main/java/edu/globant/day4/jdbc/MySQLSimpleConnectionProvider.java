package edu.globant.day4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLSimpleConnectionProvider {

	public Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://localhost:3306/training");
		String user = "root";
		String password = "lmendozaj"; //set your password here
		return DriverManager.getConnection(url, user, password);
	}
}
