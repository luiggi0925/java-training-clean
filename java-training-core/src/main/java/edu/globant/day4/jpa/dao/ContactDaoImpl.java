package edu.globant.day4.jpa.dao;

import javax.persistence.EntityManager;

import edu.globant.day4.jpa.domain.ContactJpa;

public class ContactDaoImpl extends AbstractDao<ContactJpa> implements ContactDao {

	public ContactDaoImpl(EntityManager em) {
		super(em);
	}
}
