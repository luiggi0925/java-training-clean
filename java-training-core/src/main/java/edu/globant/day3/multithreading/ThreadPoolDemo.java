package edu.globant.day3.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	static final int MAX_THREADS = 2;

	public static void main(String[] args) {
		Runnable[] tasks = {
			() -> System.out.println("Printing 10"),
			() -> System.out.println("Printing 20"),
			() -> System.out.println("Printing 30"),
			() -> System.out.println("Printing 40"),
			() -> System.out.println("Printing 50"),
			() -> System.out.println("Printing 60"),
			() -> System.out.println("Printing 70"),
			() -> System.out.println("Printing 80"),
			() -> System.out.println("Printing 90"),
			() -> System.out.println("Printing 100")
		};
		workWithThreadPool(Executors.newCachedThreadPool(), tasks);
		System.out.println("----------------------------------------------------------------");
		workWithThreadPool(Executors.newFixedThreadPool(MAX_THREADS), tasks);
		System.out.println("----------------------------------------------------------------");
		workWithThreadPool(Executors.newSingleThreadExecutor(), tasks);
	}

	public static void workWithThreadPool(ExecutorService executor, Runnable ... tasks) {
		for (Runnable task : tasks) {
			executor.execute(task);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
			//do nothing...
		}
	}
}
