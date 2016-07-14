package edu.globant.design.dip.after;

import org.apache.commons.lang3.Validate;

public class ConcreteButton {

    private Lamp lamp;

    public ConcreteButton(final Lamp lamp) {
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
