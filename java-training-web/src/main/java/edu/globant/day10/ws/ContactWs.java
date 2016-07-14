package edu.globant.day10.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import edu.globant.day10.dto.ContactDtoList;

@WebService
@SOAPBinding(style=Style.RPC)
public interface ContactWs {

	@WebMethod
	ContactDtoList getContactList();
}
