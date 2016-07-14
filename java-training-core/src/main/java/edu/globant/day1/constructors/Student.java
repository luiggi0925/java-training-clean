package edu.globant.day1.constructors;

/**
 * Class with a basic constructor
 * @author Luiggi Mendoza
 *
 */
public class Student {

	private int id;
	private String name;

	/**
	 * The constructor validates the input parameters
	 * @param id
	 * @param name
	 */
	public Student(int id, String name) {
		if (id <= 0) {
			throw new IllegalArgumentException("id must be greater than 0.");
		}
		if (name.trim().isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty.");
		}
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("Hi! This is %s and I have an id %s.", name, id);
	}

	public static void main(String[] args) {
		Student student = new Student(1, "Glober");
		System.out.println(student);
		try {
			new Student(0, "Another glober");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			new Student(2, "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
