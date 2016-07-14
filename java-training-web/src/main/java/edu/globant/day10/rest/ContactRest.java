package edu.globant.day10.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.globant.day10.dto.ContactDto;
import edu.globant.day10.dto.ContactDtoList;
import edu.globant.day10.mapper.Mapper;
import edu.globant.day9.domain.Contact;
import edu.globant.day9.factory.ServiceFactory;
import edu.globant.day9.service.ContactService;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactRest {

	@Context
    private HttpServletRequest request;

	Mapper mapper = new Mapper();

	public ContactService getContactService() {
		ServiceFactory serviceFactory = (ServiceFactory)request.getAttribute("serviceFactory");
		return serviceFactory.createContactService();
	}

	@GET
	public Response getAllContacts() {
		List<Contact> contactList = getContactService().findAll();
		List<ContactDto> contactDtoList = new ArrayList<>(contactList.size());
		for (Contact contact : contactList) {
			contactDtoList.add(mapper.getContactDto(contact));
		}
		ContactDtoList result = new ContactDtoList();
		result.setContactList(contactDtoList);
		return Response.ok(result).build();
	}

	@GET
	@Path("{id}")
	public Response getContact(@PathParam("id") Long id) {
		return Response.ok(
				mapper.getContactDto(getContactService().findById(id))
				).build();
	}
}
