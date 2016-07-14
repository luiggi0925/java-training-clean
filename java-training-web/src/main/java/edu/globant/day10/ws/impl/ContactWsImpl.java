package edu.globant.day10.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import edu.globant.day10.dto.ContactDto;
import edu.globant.day10.dto.ContactDtoList;
import edu.globant.day10.mapper.Mapper;
import edu.globant.day10.ws.ContactWs;
import edu.globant.day9.domain.Contact;
import edu.globant.day9.factory.ServiceFactory;
import edu.globant.day9.service.ContactService;

@WebService(endpointInterface="edu.globant.day10.ws.ContactWs")
public class ContactWsImpl implements ContactWs {

	@Resource
	private WebServiceContext context;

	private ServiceFactory getServiceFactory() {
		HttpServletRequest request =
				(HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
		return (ServiceFactory)request.getAttribute("serviceFactory");
	}

	@Override
	public ContactDtoList getContactList() {
		ServiceFactory serviceFactory = getServiceFactory();
		ContactService contactService = serviceFactory.createContactService();
		List<Contact> contactList = contactService.findAll();
		Mapper mapper = new Mapper();
		List<ContactDto> contactDtoList = new ArrayList<>(contactList.size());
		for (Contact contact : contactList) {
			contactDtoList.add(mapper.getContactDto(contact));
		}
		ContactDtoList result = new ContactDtoList();
		result.setContactList(contactDtoList);
		return result;
	}
}
