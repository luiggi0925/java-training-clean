package edu.globant.day8;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {

	Calculator calculator;

	@Before
	public void setup() {
		calculator = new Calculator();
	}

	@Test
	public void sum() {
		double a = 5;
		double b = 7;
		double expected = 12;
		assertThat(calculator.sum(a, b), equalTo(expected));
	}

	@Test
	public void absPositive() {
		double a = 5;
		double expected = 5;
		assertThat(calculator.abs(a), equalTo(expected));
	}

	@Ignore
	@Test
	public void absNegative() {
		//FIXME
		double a = -5;
		double expected = -5;
		assertThat(calculator.abs(a), equalTo(expected));
	}

}
