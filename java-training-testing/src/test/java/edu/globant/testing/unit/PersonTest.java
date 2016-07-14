package edu.globant.testing.unit;

import edu.globant.testing.unit.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PersonTest {

    @Test(expected = NullPointerException.class)
    public void createWithNullName() {
        new Person(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithBlankName() {
        new Person(StringUtils.EMPTY);
    }

    @Test
    public void createWithValidName() {
        Person person = new Person("test");

        assertThat("The name of the person just created does not match",
                person.getName(), equalTo("test"));
    }

    @Test(expected = NullPointerException.class)
    public void sayHelloWithNullMessage() {
        Person person = new Person("test");

        person.sayHello(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sayHelloWithBlankMessage() {
        Person person = new Person("test");

        person.sayHello(StringUtils.EMPTY);
    }

    @Test
    public void sayHelloWithValidMessage() {
        Person person = new Person("test");

        assertThat("Wrong hello message",
                person.sayHello("test"), equalTo("Hello test!"));
    }

}
