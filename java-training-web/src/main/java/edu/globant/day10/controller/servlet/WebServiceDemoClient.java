package edu.globant.day10.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.globant.day10.ws.WebServiceDemo;
import edu.globant.day10.ws.impl.WebServiceDemoImplService;


@WebServlet("/webServiceDemoClient")
public class WebServiceDemoClient extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/wsclient/webServiceDemoClient.jsp")
			.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebServiceDemoImplService client = new WebServiceDemoImplService();
		WebServiceDemo serviceInstance = client.getWebServiceDemoImplPort();
		String result = serviceInstance.sayHello(req.getParameter("txtName"));
		req.setAttribute("result", result);
		req.getRequestDispatcher("WEB-INF/wsclient/webServiceDemoClientResult.jsp")
			.forward(req, resp);
	}
}
