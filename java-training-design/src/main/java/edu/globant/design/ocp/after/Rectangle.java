package edu.globant.design.ocp.after;

public class Rectangle extends Shape {

    public Rectangle(final String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("The rectangle is: " + getName());
    }

}
