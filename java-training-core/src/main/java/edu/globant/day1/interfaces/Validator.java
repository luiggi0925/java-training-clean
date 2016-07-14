package edu.globant.day1.interfaces;

public interface Validator {

	static boolean isEmpty(String str) {
		return str == null ? true : str.trim().isEmpty();
	}
}
