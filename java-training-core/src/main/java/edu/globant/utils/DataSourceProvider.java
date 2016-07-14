package edu.globant.utils;

import javax.sql.DataSource;

public interface DataSourceProvider {

	DataSource getDataSource(String configurationPath);
}
