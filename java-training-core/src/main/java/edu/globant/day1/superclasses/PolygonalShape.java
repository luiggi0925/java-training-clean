package edu.globant.day1.superclasses;

public abstract class PolygonalShape extends Shape {

	private int sides;

	protected PolygonalShape(int sides) {
		this.sides = sides;
	}

	public int getSides() {
		return sides;
	}

	@Override
	public void draw() {
		System.out.println(String.format("This is a polygonal shape of %d sides.", sides));
	}
}
