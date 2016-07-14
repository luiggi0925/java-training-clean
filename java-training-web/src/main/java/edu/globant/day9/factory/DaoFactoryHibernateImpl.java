package edu.globant.day9.factory;

import org.hibernate.Session;

import edu.globant.day9.dao.ContactDao;
import edu.globant.day9.dao.ContactDetailTypeDao;
import edu.globant.day9.dao.hibernateimpl.ContactDaoImpl;
import edu.globant.day9.dao.hibernateimpl.ContactDetailTypeDaoImpl;

public class DaoFactoryHibernateImpl implements DaoFactory {

	private Session session;

	public DaoFactoryHibernateImpl(Session session) {
		this.session = session;
	}

	@Override
	public ContactDao createContactDao() {
		return new ContactDaoImpl(session);
	}

	@Override
	public ContactDetailTypeDao createContactDetailTypeDao() {
		return new ContactDetailTypeDaoImpl(session);
	}
}
