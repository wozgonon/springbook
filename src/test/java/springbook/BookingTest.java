package springbook;

import org.junit.Test;
import springbook.model.Booking;

import static org.junit.Assert.*;

public class BookingTest {

    final Booking booking1 = new Booking("key1", "user1", "date1", "note1");
    final Booking booking2 = new Booking("key2", "user2", "date2", "note2");

    @Test
    public void checkOneBookingsFieldsEqualsAndHashCode() {

        assertEquals("key1", booking1.getKey());
        assertEquals("user1", booking1.getUser());
        assertEquals("date1", booking1.getDate());
        assertEquals("note1", booking1.getNote());

        // Check that equals can works against other null and instances of other classes
        assertNotEquals(booking1, null);
        assertNotEquals(booking1, new Object());

        // Check that equals works against itself
        assertTrue(booking1.equals (booking1));
        // Check key is intern'ed
        assertTrue("key1" == booking1.getKey());
    }

    @Test
    public void checkTwoBookingsAgainstEachOther () {
        assertFalse(booking1.equals (booking2));
        //  The following could conceivably break if the algorithm used by the String.hashCode method ever changed.
        assertNotEquals(booking1.hashCode(), booking2.hashCode());
    }
}