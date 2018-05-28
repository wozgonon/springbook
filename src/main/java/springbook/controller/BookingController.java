/**        Springbook - simple demonstration project
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
