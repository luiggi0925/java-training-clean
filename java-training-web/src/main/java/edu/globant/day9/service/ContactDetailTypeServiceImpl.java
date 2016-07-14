package edu.globant.day9.service;

import java.util.Map;

import edu.globant.day9.dao.ContactDetailTypeDao;
import edu.globant.day9.domain.ContactDetailType;

public class ContactDetailTypeServiceImpl extends GenericServiceImpl<ContactDetailType>
	implements ContactDetailTypeService {

	private ContactDetailTypeDao dao;

	public ContactDetailTypeServiceImpl(ContactDetailTypeDao dao) {
		this.dao = dao;
	}

	public ContactDetailTypeDao getDao() {
		return dao;
	}

	@Override
	public Map<Long, ContactDetailType> getContactDetailTypeSorted() {
		return dao.getContactDetailTypeSorted();
	}
}
