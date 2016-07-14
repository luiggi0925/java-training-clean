package edu.globant.day8;

public class PersonService {

	PersonDao personDao;

	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}

	public boolean add(Person person) {
		return personDao.add(person);
	}

	public boolean remove(Person person) {
		return personDao.remove(person);
	}

	public Person find(String lastName) {
		return personDao.find(lastName);
	}
}
