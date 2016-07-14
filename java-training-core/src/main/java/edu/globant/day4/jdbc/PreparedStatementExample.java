package edu.globant.day4.jdbc;

import static edu.globant.utils.DateUtils.parseDate;
import static edu.globant.utils.DateUtils.toSqlDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.globant.utils.DateUtils;

public class PreparedStatementExample {

	public static void main(String[] args) {
		MySQLSimpleConnectionProvider simple = new MySQLSimpleConnectionProvider();
		try (Connection con = simple.getConnection()) {
			String createTable ="CREATE TABLE testTable ("
							+ "id INT PRIMARY KEY AUTO_INCREMENT,"
							+ "song VARCHAR(50) NOT NULL,"
							+ "creationDate DATE NOT NULL"
							+ ")";
			try (PreparedStatement pstmt = con.prepareStatement(createTable)) {
				pstmt.execute();
			}
			String insert = "INSERT INTO testTable VALUES (?, ?, ?)";
			try (PreparedStatement pstmt = con.prepareStatement(insert)) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
				pstmt.setString(2, "Bohemian Rapsody");
				pstmt.setDate(3, toSqlDate(parseDate("1975-10-31")));
				pstmt.executeUpdate();

				pstmt.setString(2, "Starway to Heaven");
				pstmt.setDate(3, toSqlDate(parseDate("1971-11-08")));
				pstmt.executeUpdate();

				pstmt.setString(2, "Highway to Hell");
				pstmt.setDate(3, toSqlDate(parseDate("1979-06-23")));
				pstmt.executeUpdate();

				pstmt.setString(2, "Breaking the Law");
				pstmt.setDate(3, toSqlDate(parseDate("1980-04-14")));
				pstmt.executeUpdate();
			}

			String select = "SELECT id, song, creationDate from testTable";
			try (PreparedStatement pstmt = con.prepareStatement(select)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						System.out.println(String.format("Retrieved row for id %d with content %s and date %s" ,rs.getInt("id"), rs.getString("song"), DateUtils.formatDate(rs.getDate("creationDate"))));
					}
				}
			}

			System.out.println("------------------------------------------------------------------------------------");

			String selectWithWhere = "SELECT id, song, creationDate from testTable WHERE creationDate >= ?";
			try (PreparedStatement pstmt = con.prepareStatement(selectWithWhere)) {
				pstmt.setDate(1, toSqlDate(parseDate("1980-01-01")));
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						System.out.println(String.format("Retrieved row for id %d with content %s and date %s" ,rs.getInt("id"), rs.getString("song"), DateUtils.formatDate(rs.getDate("creationDate"))));
					}
				}
			}

			String dropTable ="DROP TABLE testTable";
			try (PreparedStatement pstmt = con.prepareStatement(dropTable)) {
				pstmt.execute();
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
