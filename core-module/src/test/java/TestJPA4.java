import datamodel.Booking;
import datamodel.Facility;
import datamodel.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import services.BookingDAO;
import services.FacilityDAO;
import services.MemberDAO;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestJPA4 {

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private MemberDAO memberDAO;


    @Autowired
    private FacilityDAO facilityDAO;



    @Autowired
    private SessionFactory sf;

    @Test
    public void test() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        // sync the transactions for manually opened sessions
        TransactionSynchronizationManager.bindResource(sf, new SessionHolder(session));
        Facility facility = facilityDAO.getById(1);
        Member member = memberDAO.getById(1);
        // when
        Booking booking = bookingDAO.createBooking(member, facility, Timestamp.valueOf("2012-07-01 00:00:00"), 10);
        transaction.commit();
        TransactionSynchronizationManager.unbindResource(sf);


        // Then
        assertNotNull(member.getId());

        String bookingQuery = "SELECT b FROM Booking b WHERE b.id = :id";
        Booking createdBooking = session.createQuery(bookingQuery, Booking.class)
                .setParameter("id", booking.getId())
                .uniqueResult();
        assertNotNull(createdBooking);

        Assertions.assertEquals(booking.getStartTime(), Timestamp.valueOf("2012-07-01 00:00:00"));
        Assertions.assertEquals(booking.getSlots(), 10);
        Assertions.assertEquals(booking.getMember().getId(), createdBooking.getMember().getId());
        Assertions.assertEquals(booking.getFacility().getId(), createdBooking.getFacility().getId());

    }
}
