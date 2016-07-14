package edu.globant.day9.controller.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.globant.day9.dao.MySQLConnectionProvider;

@WebServlet("/datasourceCheck")
public class DataSourceServlet extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(DataSourceServlet.class);

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		try (Connection con = new MySQLConnectionProvider().getConnection()) {
			response.getWriter().append("<!DOCTYPE html>"
					+ "<html lang=\"en\">"
					+ "<body>"
					+ "<h1>Connection was opened</h1>"
					+ "</body>"
					+ "</html>");
		} catch (SQLException e) {
			logger.error("Error while processing request.", e);
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equals("PATCH")) {
			//....
		} else {
			super.service(req, resp);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
