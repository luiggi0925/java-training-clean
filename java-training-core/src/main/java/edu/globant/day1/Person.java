package edu.globant.day1;

/**
 * Class example with a field, methods and field encapsulation.
 * @author Luiggi Mendoza
 *
 */
public class Person {

	private String name;

	public String talk() {
		return String.format("Hear me you human! This is %s talking to you.", name);
	}

	public void eat(String food) {
		System.out.println(String.format("%s thinks that %s is delicious. Omñomñom.", name, food));
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Glober");
		System.out.println(person.talk());
		person.eat("apple");
	}
}
