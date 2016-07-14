package edu.globant.day2.exceptions;

public class ShouldNotBeHandled {

	public static void main(String[] args) {
		System.out.println("Print next message after 5 seconds aprox.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//do nothing...
		}
		System.out.println("Printed after 5 seconds aprox.");
	}
}
