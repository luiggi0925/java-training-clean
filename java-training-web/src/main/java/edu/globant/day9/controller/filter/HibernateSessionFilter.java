package edu.globant.day9.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day9.factory.DaoFactory;
import edu.globant.day9.factory.DaoFactoryHibernateImpl;
import edu.globant.day9.factory.ServiceFactory;
import edu.globant.day9.factory.ServiceFactoryImpl;

@WebFilter("/*")
public class HibernateSessionFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		if (matchesUri(req.getRequestURI())) {

			logger.info("Executing the Hibernate filter...");
			ServletContext ctx = request.getServletContext();
			SessionFactory sessionFactory = (SessionFactory)ctx.getAttribute("sessionFactory");
			try (Session session = sessionFactory.openSession()) {
				try {
					session.getTransaction().begin();
					DaoFactory daoFactory = new DaoFactoryHibernateImpl(session);
					ServiceFactory serviceFactory = new ServiceFactoryImpl(daoFactory);
	//				logger.factory("");
					request.setAttribute("serviceFactory", serviceFactory);

					chain.doFilter(request, response);

					session.getTransaction().commit();
				} catch (Exception e) {
					if (session.getTransaction().isActive()) {
						session.getTransaction().rollback();
					}
					logger.error("An error occurred while processing the transaction.", e);
				}
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public boolean matchesUri(String uri) {
		return true;
	}

	@Override
	public void destroy() {
	}
}
