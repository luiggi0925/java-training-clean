package edu.globant.day8;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PersonServiceTest {

	PersonService personService;
	String firstName = "Mari";
	String lastName = "Juárez";

	@Before
	public void init() {
		PersonDao personDao = Mockito.mock(PersonDao.class);
		Person person = new Person(firstName, lastName);
		//generic first, specific later
		Mockito.doReturn(true).when(personDao).add(Mockito.any());
		Mockito.doReturn(false).when(personDao).add(person);
		Mockito.doReturn(false).when(personDao).remove(Mockito.any());
		Mockito.doReturn(true).when(personDao).remove(person);
		Mockito.doReturn(null).when(personDao).find(Mockito.any());
		Mockito.doReturn(person).when(personDao).find(lastName);
		personService = new PersonService(personDao);
	}

	@Test
	public void shouldAdd() {
		Person person = new Person("anything", "can be inserted");
		assertThat(personService.add(person), is(true));
	}

	@Test
	public void shouldNotAdd() {
		Person person = new Person(firstName, lastName);
		assertThat(personService.add(person), is(false));
	}

	@Test
	public void shouldRemove() {
		Person person = new Person(firstName, lastName);
		assertThat(personService.remove(person), is(true));
	}

	@Test
	public void shouldNotRemove() {
		Person person = new Person("missing", "name");
		assertThat(personService.remove(person), is(false));
	}

	@Test
	public void shouldFindNothing() {
		assertThat(personService.find("find me"), is(nullValue()));
	}

	@Test
	public void shouldFindSomething() {
		assertThat(personService.find(lastName), allOf(
			is(notNullValue()),
			equalTo(new Person(firstName, lastName))
		));
	}
}
