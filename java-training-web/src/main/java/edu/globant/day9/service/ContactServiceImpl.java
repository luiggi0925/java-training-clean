package edu.globant.day9.service;

import edu.globant.day9.dao.ContactDao;
import edu.globant.day9.dao.GenericDao;
import edu.globant.day9.domain.Contact;

public class ContactServiceImpl extends GenericServiceImpl<Contact>
	implements ContactService {

	private ContactDao dao;

	public ContactServiceImpl(ContactDao dao) {
		this.dao = dao;
	}

	@Override
	public GenericDao<Contact> getDao() {
		return dao;
	}
}
