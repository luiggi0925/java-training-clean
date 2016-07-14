package edu.globant.day9.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MySQLConnectionProvider {

	private final Logger logger = LoggerFactory.getLogger(MySQLConnectionProvider.class);

	public Connection getConnection() {
		Connection con = null;
		try {
			logger.debug("Looking for the datasource using JNDI.");
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/training");
			logger.debug("Datasource found.");
			logger.debug("Opening database connection...");
			con = ds.getConnection();
			logger.debug("Connection opened successfully.");
		} catch (NamingException e) {
			logger.error("Error finding database resource.", e);
		} catch (SQLException e) {
			logger.error("Error while openning database connection.", e);
		}
		return con;
	}
}
