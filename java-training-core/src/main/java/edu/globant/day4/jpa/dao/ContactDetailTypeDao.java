package edu.globant.day4.jpa.dao;

import java.util.Map;

import edu.globant.day4.jpa.domain.ContactDetailTypeJpa;

public interface ContactDetailTypeDao extends GenericDao<ContactDetailTypeJpa> {

	Map<Long, ContactDetailTypeJpa> getContactDetailTypeSorted();
}
