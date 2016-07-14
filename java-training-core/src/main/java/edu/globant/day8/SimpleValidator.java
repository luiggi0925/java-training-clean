package edu.globant.day8;

public class SimpleValidator {

	public void validateIntegralNumber(String s) {
		if (!s.matches("-?\\d+")) {
			throw new IllegalArgumentException("String must contain digits only");
		}
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Numeric representation doesn't fit in integer");
		}
	}
}
