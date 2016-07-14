package edu.globant.design.dip.after;

public class AnotherLamp implements Lamp {

    @Override
    public void on() {
        System.out.println("Another lamp on");
    }

    @Override
    public void off() {
        System.out.println("Another lamp off");
    }

}
