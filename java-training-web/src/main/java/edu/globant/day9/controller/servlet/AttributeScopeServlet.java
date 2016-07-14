package edu.globant.day9.controller.servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/attributeScope")
public class AttributeScopeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		HttpSession session = req.getSession();

		AtomicInteger applicationScopeCounter = (AtomicInteger)sc.getAttribute("counter");
		if (applicationScopeCounter == null) {
			applicationScopeCounter = new AtomicInteger(0);
		}
		applicationScopeCounter.incrementAndGet();
		sc.setAttribute("counter", applicationScopeCounter);

		AtomicInteger sessionScopeCounter = (AtomicInteger)session.getAttribute("counter");
		if (sessionScopeCounter == null) {
			sessionScopeCounter = new AtomicInteger(0);
		}
		sessionScopeCounter.incrementAndGet();
		session.setAttribute("counter", sessionScopeCounter);

		Integer requestScopeCounter = (Integer)req.getAttribute("counter");
		if (requestScopeCounter == null) {
			requestScopeCounter = 0;
		}
		requestScopeCounter = requestScopeCounter + 1;
		req.setAttribute("counter", requestScopeCounter);

		req.getRequestDispatcher("WEB-INF/pages/AttributeScope.jsp").forward(req, resp);
	}
}
