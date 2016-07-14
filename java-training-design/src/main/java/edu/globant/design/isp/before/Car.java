package edu.globant.design.isp.before;

import org.apache.commons.lang3.Validate;

public class Car {

    private String model;

    public Car(final String model) {
        Validate.notBlank(model, "The car model cannot be blank");
        this.model = model;
    }

    public String getModel() {
        return model;
    }

}
