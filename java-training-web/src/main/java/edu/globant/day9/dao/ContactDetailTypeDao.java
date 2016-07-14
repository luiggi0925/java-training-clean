package edu.globant.day9.dao;

import java.util.Map;

import edu.globant.day9.domain.ContactDetailType;

public interface ContactDetailTypeDao extends GenericDao<ContactDetailType> {

	Map<Long, ContactDetailType> getContactDetailTypeSorted();

}