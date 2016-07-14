package edu.globant.design.ocp.after;

import edu.globant.design.ocp.after.Circle;
import edu.globant.design.ocp.after.Shape;

public class Application {

    public static void main( String[] args ) {

        Shape shape = new Circle("Circle1");

        shape.draw();

    }

}
