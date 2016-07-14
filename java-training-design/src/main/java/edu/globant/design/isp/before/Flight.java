package edu.globant.design.isp.before;

import org.apache.commons.lang3.Validate;

public class Flight {

    private String number;

    public Flight(final String number) {
        Validate.notBlank(number, "The flight number cannot be blank");
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
