package edu.globant.design.isp.before;

public class Application {

    public static void main(final String[] args) {

        BookingService service = new BookingService();

        service.book(new Flight("AA954"));
        service.book(new Hotel("NYX Hotel"));
        service.book(new Car("Honda Civic"));

    }

}
