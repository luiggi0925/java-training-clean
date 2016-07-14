package edu.globant.day1.subclasses;

import edu.globant.day1.superclasses.PolygonalShape;

public class Square extends PolygonalShape {

	public Square() {
		super(4);
	}

	@Override
	public void draw() {
		System.out.println("This is a square.");
	}
}
