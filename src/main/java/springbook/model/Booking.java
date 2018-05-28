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

package springbook.model;

@lombok.Getter
@lombok.Setter
//@lombok.RequiredArgsConstructor
//@lombok.EqualsAndHashCode(of = {"key"})
@lombok.ToString
public class Booking {

    private String key;
    private String user;
    private String date;
    private String note;

    public Booking (final String key, final String user, final String date, final String note) {
        this.key  = key.intern();
        this.user = user.intern();
        this.date = date.intern();
        this.note = note.intern();
    }
    public boolean equals (Booking other) {

        return this.key == other.key;   // Note that 'key' is intern'ed so no need to use equals
    }
    @Override
    public boolean equals (Object other) {
        return other instanceof Booking ? equals ((Booking) other) : false;
    }
    @Override
    public int hashCode () {
        return this.key.hashCode();
    }
}
