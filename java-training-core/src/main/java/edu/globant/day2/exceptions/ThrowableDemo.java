package edu.globant.day2.exceptions;

import java.util.Random;

public class ThrowableDemo {

	public static void main(String[] args) {
		try {
			Random random = new Random();
			switch(random.nextInt(2)) {
			case 0:
				showMeAnException();
				break;
			case 1:
				runUntilStackDies();
				break;
			}
		} catch (Exception e) {
			System.out.println("Let's see the name of the exception: " + e.getClass().getName());
			System.out.println("Let's see its message: " + e.getMessage());
			System.out.println("Let's see the stacktrace.");
			e.printStackTrace(System.out);
		} catch (Error e) {
			System.out.println("Let's see the name of the error: " + e.getClass().getName());
			System.out.println("Let's see its message: " + e.getMessage());
			System.out.println("Let's see the stacktrace.");
			e.printStackTrace(System.out);
		}
	}

	public static void showMeAnException() throws Exception {
		throw new Exception("I throw exceptions because yes.");
	}

	public static void runUntilStackDies() {
		runUntilStackDies();
	}
}
