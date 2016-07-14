package edu.globant.day10.rest.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

import edu.globant.day10.dto.ContactDto;

public class ContactRestClient {

	public static void main(String[] args) throws Exception {
		String baseUrl = "http://localhost:8080/java-training-web/rest/contacts";
		String resultFromGetToBaseUrl = Unirest.get(baseUrl + "/{id}")
				.routeParam("id", "1")
				.asString().getBody();
		ObjectMapper mapper = new ObjectMapper();
		ContactDto contactDto = mapper.readValue(resultFromGetToBaseUrl, ContactDto.class);
		System.out.println(String.format("%s %s", contactDto.getFirstName(), contactDto.getLastName()));
	}
}
