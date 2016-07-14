package edu.globant.day10.rest.client;

import com.mashape.unirest.http.Unirest;

public class RestDemoClient {

	public static void main(String[] args) throws Exception {
		String baseUrl = "http://localhost:8080/java-training-web/rest/restdemo";
		String resultFromGetToBaseUrl = Unirest.get(baseUrl)
				.asString().getBody();
		System.out.println(resultFromGetToBaseUrl);
		String resultFromGetToBaseUrlWithPathVar = Unirest.get(baseUrl + "/{pathVar}")
				.routeParam("pathVar", "Luiggi")
				.asString().getBody();
		System.out.println(resultFromGetToBaseUrlWithPathVar);
	}
}
