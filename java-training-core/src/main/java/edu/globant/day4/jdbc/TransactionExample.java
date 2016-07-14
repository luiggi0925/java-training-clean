package edu.globant.day4.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TransactionExample {

	public static void executeStatement(Connection con, String statement) throws SQLException {
		try (Statement stmt = con.createStatement()) {
			stmt.execute(statement);
		}
	}

	public static void executePreparedStatement(Connection con, String statement, Object... args) throws SQLException {
		try (PreparedStatement pstmt = con.prepareStatement(statement)) {
			for (int i = 1; i <= args.length; i++) {
				pstmt.setObject(i, args[i - 1]);
			}
			pstmt.executeUpdate();
		}
	}

	public static void showDataInTable(Connection con, String table) throws SQLException {
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM %s", table))) {
				ResultSetMetaData metaData = rs.getMetaData();
				int row = 1;
				while (rs.next()) {
					List<Object> data = new ArrayList<>(metaData.getColumnCount());
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						data.add(rs.getObject(i));
					}
					System.out.println(String.format("Row %d: %s", row++, data.toString()));
				}
			}
		}
	}

	public static void rollback(Connection con, Queue<Savepoint> partialCommits) throws SQLException {
		if (partialCommits.isEmpty()) {
			System.out.println("Rolling back transaction...");
			con.rollback();
			System.out.println("Rollback executed.");
		} else {
			System.out.println("Rolling back to last save point...");
			con.rollback(partialCommits.poll());
			System.out.println("Rollback executed.");
		}
	}

	public static void main(String[] args) {
		System.out.println("Starting application...");
		MySQLSimpleConnectionProvider simple = new MySQLSimpleConnectionProvider();
		try (Scanner scanner = new Scanner(System.in);
			Connection con = simple.getConnection()) {
			System.out.print("Creating table...");
			executeStatement(con,
					"CREATE TABLE IF NOT EXISTS testTransaction (id INT PRIMARY KEY AUTO_INCREMENT, val INT NOT NULL" + ")");
			System.out.println("Table created.");
			System.out.println("Initializing transaction.");
			// transaction starts
			con.setAutoCommit(false);

			boolean live = true;
			Queue<Savepoint> partialCommits = new LinkedList<>();
			while (live) {
				System.out.print("Write command or value to add: ");
				String read = scanner.nextLine();
				switch (read.toLowerCase()) {
				case "exit":
					live = false;
					break;
				case "commit":
					System.out.println("Committing transaction...");
					con.commit();
					System.out.println("Commited.");
					partialCommits.clear();
					break;
				case "pcommit":
					System.out.println("Creating save point...");
					partialCommits.add(con.setSavepoint());
					System.out.println("Save point created.");
					break;
				case "rollback":
					rollback(con, partialCommits);
					break;
				case "show":
					showDataInTable(con, "testTransaction");
					break;
				default:
					try {
						System.out.println("Adding data to the table...");
						executePreparedStatement(con, "INSERT INTO testTransaction(val) VALUES (?)", Integer.valueOf(read));
						System.out.println("Data was added.");
					} catch (Exception e) {
						// rollback if anything fails
						e.printStackTrace(System.out);
						rollback(con, partialCommits);
					}
					break;
				}
			}
			// commiting the transaction
			con.commit();
			con.setAutoCommit(true);

//			System.out.println("Dropping table...");
		} catch (SQLException e) {
			System.out.println("Issues when working with database.");
			e.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println("Unexpected problem.");
			e.printStackTrace(System.out);
		}
		System.out.println("Application finished.");
	}
}
