package edu.globant.day1.interfaces;

public interface Canvas {

	default void draw(String s) {
		System.out.println(String.format("Drawing \"%s\" in canvas.", s));
	}
}
