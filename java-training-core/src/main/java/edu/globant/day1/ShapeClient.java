package edu.globant.day1;

import static java.util.Arrays.asList;

import java.util.List;

import edu.globant.day1.subclasses.Circle;
import edu.globant.day1.subclasses.Rectangle;
import edu.globant.day1.subclasses.Square;
import edu.globant.day1.subclasses.Triangle;
import edu.globant.day1.superclasses.Shape;

public class ShapeClient {

	public static void main(String[] args) {
		//uncomment line below to see compiler error
//		Shape shape = new Shape();
		List<Shape> shapes = asList(new Circle(), new Square(), new Triangle(), new Rectangle());
		for (Shape shape : shapes) {
			shape.draw();
		}
	}
}
