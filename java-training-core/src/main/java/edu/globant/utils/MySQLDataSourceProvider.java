package edu.globant.utils;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class MySQLDataSourceProvider implements DataSourceProvider {

	@Override
	public DataSource getDataSource(String configurationPath) {
		HikariConfig hikariConfig = new HikariConfig(configurationPath);
		return new HikariDataSource(hikariConfig);
	}
}
