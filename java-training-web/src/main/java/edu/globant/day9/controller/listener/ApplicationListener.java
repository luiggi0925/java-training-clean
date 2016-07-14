package edu.globant.day9.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day9.utils.HibernateUtils;

@WebListener
public class ApplicationListener implements ServletContextListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String hibernateConfigXml = "/edu/globant/day9/config/hibernate.cfg.xml";
	private SessionFactory sessionFactory;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Initializing the application");
		logger.info("Obtaining sessionfactory from hibernate");
		try {
			sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml);
		} catch (Exception e) {
			logger.error("An error occurred while obtaining session factory from Hibernate.", e);
		}
		logger.info("Setting the session factory in application context");
		sce.getServletContext().setAttribute("sessionFactory", sessionFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
