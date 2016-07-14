package edu.globant.design.ocp.after;

public class Circle extends Shape {

    public Circle(final String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("The circle is: " + getName());
    }

}
