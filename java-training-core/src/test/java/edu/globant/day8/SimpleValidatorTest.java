package edu.globant.day8;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SimpleValidatorTest {

	@Rule
	public ExpectedException expected = ExpectedException.none();

	@Test
	public void shouldThrowExceptionUsingTryCatch() {
		try {
			new SimpleValidator().validateIntegralNumber("globant");
			fail("Exception was not thrown");
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("String must contain digits only"));
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionUsingAnnotationField() {
		new SimpleValidator().validateIntegralNumber("globant");
	}

	@Test
	public void shouldThrowExceptionUsingRule() {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("String must contain digits only");
		new SimpleValidator().validateIntegralNumber("globant");
	}

	@Test
	public void shouldThrowExceptionUsingTryCatchValidNumber() {
		try {
			new SimpleValidator().validateIntegralNumber("2147483648");
			fail("Exception was not thrown");
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Numeric representation doesn't fit in integer"));
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionUsingAnnotationFieldValidNumber() {
		new SimpleValidator().validateIntegralNumber("2147483648");
	}

	@Test
	public void shouldThrowExceptionUsingRuleValidNumber() {
		expected.expect(IllegalArgumentException.class);
		expected.expectMessage("Numeric representation doesn't fit in integer");
		new SimpleValidator().validateIntegralNumber("2147483648");
	}
}
