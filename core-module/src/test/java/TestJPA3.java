import datamodel.Booking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestJPA3 {

    @Autowired
    private SessionFactory sf;

    @Test
    @Transactional
    public void test() {
        // Given
        Session session = sf.openSession();
        int expectedSize = 4044;

        // When
        List<Booking> bookings = session.createQuery("SELECT b FROM Booking b", Booking.class)
                .getResultList();

        // Then
        Assertions.assertEquals(expectedSize, bookings.size());
        Assertions.assertNotNull(bookings.get(0).getMember());
        Assertions.assertNotNull(bookings.get(0).getFacility());

    }
}
