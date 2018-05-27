package springbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springbook.model.Booking;
import springbook.service.BookingService;

import java.util.Collection;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping("/booking/create")
    public Booking createBooking(@RequestParam String user, @RequestParam String date, @RequestParam String note) {
        return bookingService.createBooking(user, date, note);
    }

    @RequestMapping("/booking/delete")
    public void deleteBooking(@RequestParam String bookingId) throws BookingService.UnknownBooking {
        bookingService.deleteBooking(bookingId);
    }

    @RequestMapping("/booking/list")
    public Collection<Booking> listBookings(@RequestParam String user) {
        return bookingService.listBookings(user);
    }
}
