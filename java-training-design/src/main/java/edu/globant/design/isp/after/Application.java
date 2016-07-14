package edu.globant.design.isp.after;

public class Application {

    public static void main(final String[] args) {

        HotelService hotelService = new BookingService();
        FlightService flightService = new BookingService();
        CarService carService = new BookingService();

        flightService.book(new Flight("AA954"));
        hotelService.book(new Hotel("NYX Hotel"));
        carService.book(new Car("Honda Civic"));

    }

}
