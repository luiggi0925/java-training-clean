package edu.globant.day9.factory;

import edu.globant.day9.service.ContactDetailTypeService;
import edu.globant.day9.service.ContactDetailTypeServiceImpl;
import edu.globant.day9.service.ContactService;
import edu.globant.day9.service.ContactServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {

	private DaoFactory daoFactory;

	public ServiceFactoryImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public ContactService createContactService() {
		return new ContactServiceImpl(daoFactory.createContactDao());
	}

	@Override
	public ContactDetailTypeService createContactDetailTypeService() {
		return new ContactDetailTypeServiceImpl(daoFactory.createContactDetailTypeDao());
	}

}
