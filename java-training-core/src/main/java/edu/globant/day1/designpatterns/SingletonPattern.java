package edu.globant.day1.designpatterns;

import java.io.PrintStream;

public final class SingletonPattern {

	private final PrintStream out;

	private SingletonPattern() {
		//start elements
		//tighly coupled to resources
		out = System.out;
	}

	private static final SingletonPattern instance = new SingletonPattern();

	public static SingletonPattern getSingletonPattern() {
		return instance;
	}

	public void info(String s) {
		out.println("[INFO] " + s);
	}

	public void error(String s, Exception e) {
		out.println("[ERROR] " + s);
		if (e != null) {
			e.printStackTrace(out);
		}
	}

	public void error(String s) {
		error(s, null);
	}

	public static void main(String[] args) {
		SingletonPattern.getSingletonPattern().info("Hello world");
		SingletonPattern.getSingletonPattern().error("An error happened");
		SingletonPattern.getSingletonPattern().error("More details of the error.", new Exception("This is an exception."));
	}
}
