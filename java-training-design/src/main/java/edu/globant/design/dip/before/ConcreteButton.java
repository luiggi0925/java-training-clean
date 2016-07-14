package edu.globant.design.dip.before;

import org.apache.commons.lang3.Validate;

public class ConcreteButton {

    private ConcreteLamp lamp;

    public ConcreteButton(final ConcreteLamp lamp) {
        Validate.notNull(lamp, "The lamp cannot be null");
        this.lamp = lamp;
    }

    public void on() {
        lamp.on();
    }

    public void off() {
        lamp.off();
    }

}
