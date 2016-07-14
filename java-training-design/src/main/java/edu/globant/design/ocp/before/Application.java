package edu.globant.design.ocp.before;

public class Application {

    public static void main( String[] args ) {

        Shape shape = new Circle("Circle1");

        if (shape.getType().equals(ShapeType.CIRCLE)) {
            drawCircle(shape);
        } else if (shape.getType().equals(ShapeType.RECTANGLE)) {
            drawRectangle(shape);
        }

    }

    private static void drawCircle(Shape shape) {
        System.out.println("The circle is: " + shape.getName());
    }

    private static void drawRectangle(Shape shape) {
        System.out.println("The rectangle is: " + shape.getName());
    }

}
