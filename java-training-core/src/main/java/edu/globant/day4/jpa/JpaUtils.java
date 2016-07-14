package edu.globant.day4.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;

public class JpaUtils {

	public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName, DataSource ds) {
		Map<String, Object> properties = new HashMap<>();
		if (ds != null) {
			properties.put(AvailableSettings.DATASOURCE, ds);
		}
		return Persistence.createEntityManagerFactory(persistenceUnitName, properties);
	}
}
