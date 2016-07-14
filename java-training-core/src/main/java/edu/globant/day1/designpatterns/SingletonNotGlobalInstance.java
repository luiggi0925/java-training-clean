package edu.globant.day1.designpatterns;

import java.io.PrintStream;

public class SingletonNotGlobalInstance {

	private final PrintStream out;

	private SingletonNotGlobalInstance(PrintStream out) {
		//start elements
		this.out = out;
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
		SingletonNotGlobalInstance mySingleton = new SingletonNotGlobalInstance(System.out);
//		SingletonPattern.getSingletonPattern().info("Hello world");
//		SingletonPattern.getSingletonPattern().error("An error happened");
//		SingletonPattern.getSingletonPattern().error("More details of the error.", new Exception("This is an exception."));
		mySingleton.info("Hello world");
		mySingleton.info("Hello world");
		mySingleton.info("Hello world");
	}
}
