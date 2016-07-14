package edu.globant.design.isp.before;

public class BookingService {

    public void book(final Hotel hotel) {
        System.out.println("Booking hotel [" + hotel.getName() + "]");
    }

    public void book(final Flight flight) {
        System.out.println("Booking flight [" + flight.getNumber() + "]");
    }

    public void book(final Car car) {
        System.out.println("Booking car [" + car.getModel() + "]");
    }

}