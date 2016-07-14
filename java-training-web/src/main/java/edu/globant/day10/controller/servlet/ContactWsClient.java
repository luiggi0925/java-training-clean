package edu.globant.day10.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.globant.day10.ws.ContactWs;
import edu.globant.day10.ws.impl.ContactWsImplService;

@WebServlet("/contactWsClient")
public class ContactWsClient extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactWsImplService client = new ContactWsImplService();
		ContactWs serviceInstance = client.getContactWsImplPort();
		req.setAttribute("contactList", serviceInstance.getContactList().getContactList());
		req.getRequestDispatcher("WEB-INF/wsclient/contactWsClient.jsp").forward(req, resp);
	}
}
