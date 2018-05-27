package springbook;

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
