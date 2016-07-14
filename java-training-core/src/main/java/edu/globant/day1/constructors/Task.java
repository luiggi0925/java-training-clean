package edu.globant.day1.constructors;

/**
 * Class with two constructors.
 * @author Luiggi Mendoza
 *
 */
public class Task {

	private String title;

	private String description;

	/**
	 * This constructor sets a default value for description field.
	 * @param title
	 */
	public Task(String title) {
		this(title, "The title says it all");
	}

	/**
	 * Constructor that accepts both title and description
	 * @param title
	 * @param description
	 */
	public Task(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Title: %s. Description: %s.", title, description);
	}

	public static void main(String[] args) {
		Task task1 = new Task("Study Java");
		Task task2 = new Task("Get vegetables", "Go to the grocery store and buy some lettuce and tomato for the salad");
		System.out.println(task1);
		System.out.println(task2);
	}
}
