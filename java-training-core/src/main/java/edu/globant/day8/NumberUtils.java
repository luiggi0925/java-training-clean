package edu.globant.day8;

public class NumberUtils {

	public int toInt(final String s) {
		return toInt(s, 0);
	}

	public int toInt(String s, int defaultValue) {
		if(s == null) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(s);
		} catch (final NumberFormatException nfe) {
			return defaultValue;
		}
	}
}
