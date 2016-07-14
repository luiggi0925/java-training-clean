package edu.globant.day1.subclasses;

import edu.globant.day1.superclasses.PolygonalShape;

public class Triangle extends PolygonalShape {

	public Triangle() {
		super(3);
	}

	@Override
	public void draw() {
		System.out.println("This is a triangle.");
	}
}
