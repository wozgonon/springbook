package springbook;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = SpringBookController.class, secure = false)
//@ContextConfiguration(locations = "classpath:application.properties")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBookTest {

    @Autowired
    SpringBookController springBook;

    @Test
    @Ignore
    public void shouldCreateBooking () {
        final Booking booking = springBook.createBooking("aUser", "aDate", "aNote");
        //assert
    }
    @Test
    @Ignore
    public void shouldDeleteBooking() throws BookingService.UnknownBooking {
        springBook.deleteBooking("aID");
    }
    @Test
    @Ignore
    public void shouldListBookings() {
        final Collection<Booking> bookings = springBook.listBookings("aUser");
    }
}
