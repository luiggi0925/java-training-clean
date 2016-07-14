package edu.globant.design.ocp.before;

public class Rectangle extends Shape {

    public Rectangle(final String name) {
        super(name);
    }

    @Override
    public ShapeType getType() {
        return ShapeType.RECTANGLE;
    }

}
