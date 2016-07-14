package edu.globant.day4.hibernate.dao;

import org.hibernate.Session;

import edu.globant.day4.hibernate.domain.Contact;

public class ContactDao extends AbstractDao<Contact> {

	public ContactDao(Session session) {
		super(session);
	}
}
