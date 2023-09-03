import datamodel.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestJPA1 {

    @Autowired
    private SessionFactory sf;

    @Test
    public void test() {
        Member member = new Member( "Doe", "John", "123 Main St", 12345, "555-1234", 2, Timestamp.valueOf("2022-01-01 00:00:00"));

        // When
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(member);
        transaction.commit();

        // Then
        assertNotNull(member.getId());

        String memberQuery = "SELECT m FROM Member m WHERE m.id = :id";
        Member createdMember = session.createQuery(memberQuery, Member.class)
                .setParameter("id", member.getId())
                .uniqueResult();
        assertNotNull(createdMember);

        Assertions.assertEquals(member.getSurname(), createdMember.getSurname());
        Assertions.assertEquals(member.getFirstName(), createdMember.getFirstName());
        Assertions.assertEquals(member.getAddress(), createdMember.getAddress());
        Assertions.assertEquals(member.getZipcode(), createdMember.getZipcode());
        Assertions.assertEquals(member.getTelephone(), createdMember.getTelephone());
        Assertions.assertEquals(member.getRecommendedBy(), createdMember.getRecommendedBy());
        Assertions.assertEquals(member.getJoinDate(), createdMember.getJoinDate());

    }

}
