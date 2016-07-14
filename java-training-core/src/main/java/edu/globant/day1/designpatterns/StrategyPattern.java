package edu.globant.day1.designpatterns;

class ToDo {
	private final String description;
	public ToDo(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}

interface Worker {
	void doWork(ToDo todo);
}

class HomeWorker implements Worker {
	@Override
	public void doWork(ToDo todo) {
		System.out.println("Relaxing a bit...");
		System.out.println("Let's prepare some coffee.");
		System.out.println("Time to read facebook...");
		System.out.println("Ok, let's work on the todo: " + todo.getDescription());
		System.out.println("It's comfortable to work at home.");
	}
}

class OfficeWorker implements Worker {
	@Override
	public void doWork(ToDo todo) {
		System.out.println("Here we go. I have this todo: " + todo.getDescription());
		if (todo.getDescription().length() > 50) {
			System.out.println("Looks like lot of work to do. Let's focus.");
			System.out.println("Oops! There's a new email. Let's check it out.");
			System.out.println("This will take the whole morning. Hope I can finish it soon");
		} else {
			System.out.println("Piece of cake.");
			System.out.println("Aaaaand... it's done!");
		}
	}
}

public class StrategyPattern {

	public static void main(String[] args) {
		haveSomeWork("Define new set of classes and interfaces for a case selling business", new HomeWorker());
		haveSomeWork("Define new set of classes and interfaces for a case selling business", new OfficeWorker());
		System.out.println("------------------------------------------------------------------------------------");
		haveSomeWork("Do the dishes", new HomeWorker());
		haveSomeWork("Do the dishes", new OfficeWorker());
	}

	static void haveSomeWork(String description, Worker worker) {
		worker.doWork(new ToDo(description));
	}
}
