package edu.globant.testing.integration;

import org.apache.commons.lang3.Validate;

public class PersonService {

    private PersonDAO dao;

    public PersonService(final PersonDAO dao) {
        Validate.notNull(dao, "The dao cannot be null");
        this.dao = dao;
    }

    public void create(final String name) {
        Validate.notBlank(name, "The name cannot be blank.");
        this.dao.store(new Person(name));
    }

    public Person findBy(final String name) {
        Validate.notBlank(name, "The name cannot be blank.");
        return this.dao.findBy(name);
    }

}
