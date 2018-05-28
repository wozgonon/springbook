/**       Springbook - simple demonstration project
 *        Copyright (C) 2018 JB
 *
 *        This program is free software; you can redistribute it and/or modify
 *        it under the terms of the GNU General Public License as published by
 *        the Free Software Foundation; either version 2 of the License, or
 *        (at your option) any later version.
 *
 *        This program is distributed in the hope that it will be useful,
 *        but WITHOUT ANY WARRANTY; without even the implied warranty of
 *        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *        GNU General Public License for more details.
 *
 *        You should have received a copy of the GNU General Public License along
 *        with this program; if not, write to the Free Software Foundation, Inc.,
 *        51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 **/
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
