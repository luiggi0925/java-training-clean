package edu.globant.day9.dao.hibernateimpl;

import org.hibernate.Session;

import edu.globant.day9.dao.ContactDao;
import edu.globant.day9.domain.Contact;

public class ContactDaoImpl extends AbstractDao<Contact>
	implements ContactDao {

	public ContactDaoImpl(Session session) {
		super(session);
	}
}
