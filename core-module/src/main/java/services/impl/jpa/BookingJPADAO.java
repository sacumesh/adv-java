package services.impl.jpa;

import datamodel.Booking;
import datamodel.Facility;
import datamodel.Member;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import services.BookingDAO;
import services.FacilityDAO;

import java.sql.Timestamp;
import java.util.List;
public class BookingJPADAO extends AbstractJPADAO<Booking> implements BookingDAO {

    public BookingJPADAO(SessionFactory sf) {
        super(sf, Booking.class);
    }


    @Override
    public List<Booking> search(Booking instance) {
        return null;
    }

    public Booking createBooking(Member member, Facility facility, Timestamp startTime, Integer slots) {
        Booking booking = new Booking(member, facility, startTime, slots);
        create(booking);
        return booking;
    }
}
