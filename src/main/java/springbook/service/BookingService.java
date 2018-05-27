package springbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbook.model.Booking;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

/**
 * A non-persistent (in-memory) service for bookings.
 */
@Service
public class BookingService {

    private final HashMap<String,Booking> bookings = new HashMap<>();

    @Autowired
    BookingService bookingService;

    public Booking createBooking (final String user, final String date, final String note) {
        final String key = UUID.randomUUID().toString().intern();
        final Booking booking = new Booking(key, user, date, note);
        this.bookings.put (key, booking);
        return booking;
    }

    public void deleteBooking(final String bookingId) throws UnknownBooking {
        final String key = bookingId.intern();
        final Booking booking = this.bookings.remove(key);
        if (booking == null) {
            throw new UnknownBooking(key);
        }
    }
    public Collection<Booking> listBookings(final String user) {
        return this.bookings.values();
    }

    public static class UnknownBooking extends Throwable {
        public UnknownBooking (String key) {
            super (key);
        }
    }
}
