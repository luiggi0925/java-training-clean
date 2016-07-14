package edu.globant.day4.hibernate;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day4.hibernate.domain.Contact;
import edu.globant.day4.hibernate.domain.ContactDetail;
import edu.globant.day4.hibernate.domain.ContactDetailType;

public final class HibernateUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtils.class);

	public static SessionFactory buildSessionFactory(String hibernateConfigXml, DataSource dataSource) {
		try {
			Configuration configuration = new Configuration();

			configuration.configure(hibernateConfigXml)
				.addAnnotatedClass(Contact.class)
				.addAnnotatedClass(ContactDetail.class)
				.addAnnotatedClass(ContactDetailType.class);
			SessionFactory sf = configuration
				.buildSessionFactory(
					new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.applySetting(Environment.DATASOURCE, dataSource)
						.build());
			return sf;
		} catch (Exception ex) {
			LOGGER.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
