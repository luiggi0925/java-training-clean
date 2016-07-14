package edu.globant.day10.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/restdemo")
public class RestDemo {

	@GET
	@Produces("application/json")
	public Response sayHelloDefault() {
		Map<String, String> result = new HashMap<>();
		result.put("sayHello", "hello world");
		return Response.ok(result).build();
	}

	@GET
	@Path("{pathVar}")
	@Produces("application/json")
	public Response sayHello(@PathParam("pathVar") String pathVariable) {
		Map<String, String> result = new HashMap<>();
		result.put("sayHello", "hello " + pathVariable);
		return Response.ok(result).build();
	}

}
