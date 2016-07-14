package edu.globant.day9.factory;

import edu.globant.day9.dao.ContactDao;
import edu.globant.day9.dao.ContactDetailTypeDao;

public interface DaoFactory {

	public ContactDao createContactDao();
	public ContactDetailTypeDao createContactDetailTypeDao();
}
