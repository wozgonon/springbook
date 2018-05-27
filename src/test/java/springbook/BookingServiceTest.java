package springbook;

import org.junit.Ignore;
import org.junit.Test;
import springbook.model.Booking;
import springbook.service.BookingService;

import java.util.Collection;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BookingServiceTest {

    //@Autowired
    final BookingService bookingService = new BookingService();

    @Test
    public void listInitialEmptyBookings() {
        final Collection<Booking> bookings = bookingService.listBookings("aUser");
        assertEquals(0, bookings.size());
    }

    @Test(expected = BookingService.UnknownBooking.class)
    public void deleteUnknownBooking() throws BookingService.UnknownBooking {

        bookingService.deleteBooking("unknownID");
    }

    @Test
    public void createAndThenListFirstBooking() throws BookingService.UnknownBooking {
        System.out.println("createAndThenListFirstBooking: " + bookingService);

        final Collection<Booking> bookings_before_create = bookingService.listBookings("aUser");
        assertEquals(0, bookings_before_create.size());

        final Booking booking = bookingService.createBooking("aUser", "aDate", "aNote");
        assertEquals("aUser", booking.getUser());
        assertEquals("aDate", booking.getDate());
        assertEquals("aNote", booking.getNote());

        final Collection<Booking> bookings_after_create = bookingService.listBookings("aUser");
        assertEquals(1, bookings_after_create.size());
        assertEquals(booking, bookings_after_create.iterator().next());
    }

    @Test
    public void createAndThenDeleteFirstBooking() throws BookingService.UnknownBooking {
        final Collection<Booking> bookings_before_delete = bookingService.listBookings("aUser");
        assertEquals(0, bookings_before_delete.size());

        final Booking booking = bookingService.createBooking("aUser", "aDate", "aNote");
        bookingService.deleteBooking(booking.getKey());

        final Collection<Booking> bookings_after_delete = bookingService.listBookings("aUser");
        assertEquals(0, bookings_after_delete.size());
    }

    @Test
    public void createTwoBookingAndThenDeleteListFirstBooking() throws BookingService.UnknownBooking {

        final Collection<Booking> bookings_before_create = bookingService.listBookings("aUser");
        assertEquals(0, bookings_before_create.size());

        final Booking booking1 = bookingService.createBooking("aUser", "aDate", "activity1");
        final Booking booking2 = bookingService.createBooking("aUser", "aDate", "activity2");

        // Check the two bookings have user key and date but different key and note
        assertNotEquals(booking1.getKey(), booking2.getKey());
        assertEquals(booking1.getUser(), booking2.getUser());
        assertEquals(booking1.getDate(), booking2.getDate());
        assertNotEquals(booking1.getNote(), booking2.getNote());
        assertEquals("activity1", booking1.getNote());
        assertEquals("activity2", booking2.getNote());

        // Check list of bookings contains just the two bookings just created
        final Collection<Booking> bookings_after_create = bookingService.listBookings("aUser");
        assertEquals(2, bookings_before_create.size());
        assertTrue (bookings_after_create.contains(booking1));
        assertTrue (bookings_after_create.contains(booking2));

        // Delete one of the bookings
        bookingService.deleteBooking(booking1.getKey());
        final Collection<Booking> bookings_after_delete = bookingService.listBookings("aUser");
        assertEquals(1, bookings_after_delete.size());
        assertFalse (bookings_after_delete.contains(booking1));
        assertTrue (bookings_after_delete.contains(booking2));
    }

    @Test
    @Ignore
    public void createTwoBookingsDeleteOneAndCreateAnother() {
    }

    @Test
    @Ignore
    public void createBookingsDeleteKnownAndUnknownNTimes () {
    }
}