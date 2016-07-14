package edu.globant.design.ocp.after;

import org.apache.commons.lang3.Validate;

public abstract class Shape {

    private String name;

    public Shape(final String name) {
        Validate.notBlank(name, "The name cannot be blank");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void draw();

}
