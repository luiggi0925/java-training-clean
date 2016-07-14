package edu.globant.design.dip.before;

public class Application {

    public static void main(final String[] args) {

        ConcreteLamp lamp = new ConcreteLamp();

        ConcreteButton button = new ConcreteButton(lamp);

        button.on();
        button.off();

    }

}
