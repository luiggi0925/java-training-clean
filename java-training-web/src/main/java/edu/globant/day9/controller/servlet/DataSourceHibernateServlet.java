package edu.globant.day9.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day9.utils.HibernateUtils;

@WebServlet("/datasourceHibernateCheck")
public class DataSourceHibernateServlet extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(DataSourceHibernateServlet.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String hibernateConfigXml = "/edu/globant/day9/config/hibernate.cfg.xml";
		try (SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml)) {
			try (Session session = sessionFactory.openSession()) {
				response.getWriter().append("<!DOCTYPE html>"
						+ "<html lang=\"en\">"
						+ "<body>"
						+ "<h1>Connection was opened</h1>"
						+ "</body>"
						+ "</html>");
			} catch (Exception e) {
				logger.error("Error while opening Hibernate Session.", e);
			}
		} catch (Exception e) {
			logger.error("Error while creating Hibernate SessionFactory.", e);
		}
	}
}
