package edu.globant.testing.unit;

import org.apache.commons.lang3.Validate;

public class Person {

    private String name;

    public Person(final String name) {
        Validate.notBlank(name, "The name cannot be blank.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sayHello(final String message) {
        Validate.notBlank(message, "The message cannot be blank.");
        return "Hello " + message + "!";
    }

}
