package edu.globant.day10.ws.impl;

import javax.jws.WebService;

import edu.globant.day10.ws.WebServiceDemo;

@WebService(endpointInterface = "edu.globant.day10.ws.WebServiceDemo")
public class WebServiceDemoImpl implements WebServiceDemo {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}
}
