package springbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class SpringBookController {

    @Autowired
    BookingService bookingService;

    @RequestMapping("/booking/create")
    public Booking createBooking(@PathVariable String user, @PathVariable String date, @PathVariable String note) {
        return bookingService.createBooking(user, date, note);
    }

    @RequestMapping("/booking/delete")
    public void deleteBooking(@PathVariable String bookingId) throws BookingService.UnknownBooking {
        bookingService.deleteBooking(bookingId);
    }

    @RequestMapping("/booking/list")
    public Collection<Booking> listBookings(@PathVariable String user) {
        return bookingService.listBookings(user);
    }
}

