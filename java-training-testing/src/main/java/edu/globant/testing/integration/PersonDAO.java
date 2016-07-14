package edu.globant.testing.integration;

import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;

public class PersonDAO {

    private Map<String, Person> persons = new HashMap<>();

    public void store(final Person person) {
        Validate.notNull(person, "The person cannot be null");
        persons.put(person.getName(), person);
    }

    public Person findBy(final String name) {
        Validate.notBlank(name, "The name cannot be blank");
        return persons.get(name);
    }

}
