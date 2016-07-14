package edu.globant.day9.factory;

import edu.globant.day9.service.ContactDetailTypeService;
import edu.globant.day9.service.ContactService;

public interface ServiceFactory {

	ContactService createContactService();
	ContactDetailTypeService createContactDetailTypeService();
}
