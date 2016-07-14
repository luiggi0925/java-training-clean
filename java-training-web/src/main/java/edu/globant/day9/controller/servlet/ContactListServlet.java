package edu.globant.day9.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.globant.day9.domain.Contact;
import edu.globant.day9.factory.ServiceFactory;

@WebServlet("/app/index")
public class ContactListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServiceFactory serviceFactory = (ServiceFactory)request.getAttribute("serviceFactory");
		if (serviceFactory != null) {
			List<Contact> contactList = serviceFactory.createContactService().findAll();
			request.setAttribute("contactList", contactList);
		}
		request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
	}
}
