package edu.globant.day9.controller.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.globant.day9.domain.Contact;
import edu.globant.day9.factory.ServiceFactory;

@WebServlet("/app/contacts")
public class ContactServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Optional<String> id = Optional.ofNullable(request.getParameter("id"));
		id.ifPresent(x -> {
			ServiceFactory serviceFactory = (ServiceFactory)request.getAttribute("serviceFactory");
			Contact contact = serviceFactory.createContactService().findById(Long.valueOf(x));
			request.setAttribute("contact", contact);
		});
		request.getRequestDispatcher("WEB-INF/pages/contact.jsp").forward(request, response);
	}
}
