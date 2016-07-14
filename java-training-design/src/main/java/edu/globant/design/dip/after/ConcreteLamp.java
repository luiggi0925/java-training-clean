package edu.globant.design.dip.after;

public class ConcreteLamp implements Lamp {

    @Override
    public void on() {
        System.out.println("Concrete lamp on");
    }

    @Override
    public void off() {
        System.out.println("Concrete lamp off");
    }

}
