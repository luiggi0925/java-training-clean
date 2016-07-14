package edu.globant.day9.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day9.domain.Contact;
import edu.globant.day9.domain.ContactDetail;
import edu.globant.day9.domain.ContactDetailType;

public final class HibernateUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtils.class);

	public static SessionFactory buildSessionFactory(String hibernateConfigXml) {
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
						.build());
			return sf;
		} catch (Exception ex) {
			LOGGER.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
