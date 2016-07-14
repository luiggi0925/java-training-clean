package edu.globant.design.ocp.before;

public class Circle extends Shape {

    public Circle(final String name) {
        super(name);
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CIRCLE;
    }

}
