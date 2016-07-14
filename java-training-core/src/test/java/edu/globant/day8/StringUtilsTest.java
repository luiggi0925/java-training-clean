package edu.globant.day8;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StringUtilsTest {

	StringUtils stringUtils;

	@Before
	public void setup() {
		stringUtils = new StringUtils();
	}

	@Test
	public void emptyStringForNull() {
		assertThat(stringUtils.isEmpty(null), is(true));
	}
}
