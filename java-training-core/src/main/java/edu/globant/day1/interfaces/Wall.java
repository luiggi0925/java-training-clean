package edu.globant.day1.interfaces;

public interface Wall {

	default void draw(String s) {
		System.out.println(String.format("Drawing \"%s\" in wall.", s));
	}
}
