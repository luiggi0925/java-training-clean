package edu.globant.design.isp.after;

public class BookingService implements HotelService, FlightService, CarService {

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