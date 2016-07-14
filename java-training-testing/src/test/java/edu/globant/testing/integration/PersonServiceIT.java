package edu.globant.testing.integration;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PersonServiceIT {

    private PersonService service;

    @Before
    public void setUp() {
        service = new PersonService(new PersonDAO());
    }

    @Test
    public void storeAndRetrieve() {
        service.create("test");
        Person person = service.findBy("test");

        assertThat("The person just created and retrieved is null", person, notNullValue());
        assertThat("Wrong person just created and retrieved", person.getName(), equalTo("test"));
    }

}
