package edu.globant.design.isp.before;

import org.apache.commons.lang3.Validate;

public class Hotel {

    private String name;

    public Hotel(final String name) {
        Validate.notBlank(name, "The hotel name cannot be blank");
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
