package edu.globant.day4.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.globant.utils.DateUtils;

public class StatementExample {

	public static void main(String[] args) {
		MySQLSimpleConnectionProvider simple = new MySQLSimpleConnectionProvider();
		try (Connection con = simple.getConnection()) {

			try (Statement statement = con.createStatement()) {
				statement.execute("DROP TABLE IF EXISTS testTable");
				statement.execute("CREATE TABLE testTable ("
						+ "id INT PRIMARY KEY AUTO_INCREMENT,"
						+ "song VARCHAR(50) NOT NULL,"
						+ "creationDate DATE NOT NULL"
						+ ")");
				statement.executeUpdate("INSERT INTO testTable VALUES (NULL, 'Bohemian Rapsody', '1975-10-31')");
				statement.executeUpdate("INSERT INTO testTable VALUES (NULL, 'Starway to Heaven', '1971-11-08')");
				statement.executeUpdate("INSERT INTO testTable VALUES (NULL, 'Highway to Hell', '1979-06-23')");
				statement.executeUpdate("INSERT INTO testTable VALUES (NULL, 'Breaking the Law', '1980-04-14')");

				try (ResultSet rs = statement.executeQuery("SELECT id, song, creationDate from testTable")) {
					while (rs.next()) {
						System.out.println(String.format("Retrieved row for id %d with content %s and date %s" ,rs.getInt("id"), rs.getString("song"), DateUtils.formatDate(rs.getDate("creationDate"))));
					}
				}

				System.out.println("------------------------------------------------------------------------------------");

				try (ResultSet rs = statement.executeQuery("SELECT id, song, creationDate from testTable WHERE creationDate >= '1980-01-01'")) {
					while (rs.next()) {
						System.out.println(String.format("Retrieved row for id %d with content %s and date %s" ,rs.getInt("id"), rs.getString("song"), DateUtils.formatDate(rs.getDate("creationDate"))));
					}
				}

				statement.execute("DROP TABLE testTable");
			}
		} catch(SQLException e) {
			System.out.println("Issues when working with database.");
			e.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println("Unexpected problem.");
			e.printStackTrace(System.out);
		}
	}
}
