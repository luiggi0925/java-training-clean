package edu.globant.day8;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NumberUtilsTest {

	NumberUtils numberUtils;

	@Before
	public void setup() {
		numberUtils = new NumberUtils();
	}

	@Test
	public void emptyStringForNull() {
		assertThat(numberUtils.toInt(null), equalTo(0));
	}
}
