package edu.globant.day8;

import java.util.HashMap;
import java.util.Map;

public class PersonDao {

	private Map<String, Person> data = new HashMap<>();

	public boolean add(Person person) {
		return data.putIfAbsent(person.getLastName(), person) == null;
	}

	public boolean remove(Person person) {
		return data.remove(person.getLastName()) != null;
	}

	public Person find(String lastName) {
		return data.get(lastName);
	}
}
