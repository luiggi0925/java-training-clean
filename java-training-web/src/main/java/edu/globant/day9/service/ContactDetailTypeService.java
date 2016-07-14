package edu.globant.day9.service;

import java.util.Map;

import edu.globant.day9.domain.ContactDetailType;

public interface ContactDetailTypeService extends GenericService<ContactDetailType> {

	Map<Long, ContactDetailType> getContactDetailTypeSorted();
}
