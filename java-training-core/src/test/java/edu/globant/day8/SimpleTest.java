package edu.globant.day8;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Unit test class for SimpleClass
 *
 * @author Luiggi Mendoza
 *
 */
public class SimpleTest {

	@Test
	public void checkHello() {
		SimpleClass simpleClass = new SimpleClass();
		assertThat(simpleClass.sayHello("Glober"), equalTo("Hello Glober"));
	}

}
