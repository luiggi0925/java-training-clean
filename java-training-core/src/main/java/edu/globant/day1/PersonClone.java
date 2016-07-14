package edu.globant.day1;

class StringUtils {
	public String toUpper(String s) {
		return s == null ? "" : s.toUpperCase();
	}
}

class PersonService {
	StringUtils stringUtils;

	public PersonService(StringUtils stringUtils) {
		this.stringUtils = stringUtils;
	}

	public void showPersonNameInUpperCase(PersonClone person) {
		System.out.println(String.format("My name in upper case: %s.", stringUtils.toUpper(person.getName())));
	}
}

/**
 * Class example with a field, methods and field encapsulation.
 * @author Luiggi Mendoza
 *
 */
public class PersonClone {

	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void showUpperCaseName() {
		System.out.println(String.format("My name in upper case: %s.", name.toUpperCase()));
	}

	public static void main(String[] args) {
		PersonClone person = new PersonClone();
		person.setName("Luiggi");
//		person.showUpperCaseName();
		new PersonService(new StringUtils()).showPersonNameInUpperCase(person);
	}
}
