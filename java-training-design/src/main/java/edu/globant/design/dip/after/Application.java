package edu.globant.design.dip.after;

public class Application {

    public static void main(final String[] args) {

        Lamp lamp = new ConcreteLamp();
        //Lamp lamp = new AnotherLamp();

        ConcreteButton button = new ConcreteButton(lamp);

        button.on();
        button.off();

    }

}
