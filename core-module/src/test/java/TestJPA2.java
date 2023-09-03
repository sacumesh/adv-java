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
import services.FacilityDAO;
import services.MemberDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestJPA2 {

    @Autowired
    private MemberDAO memberDAO;


    @Autowired
    private FacilityDAO facilityDAO;


    @Test
    @Transactional
    public void testMemberCount() throws SQLException {

        // When
        List<Member> members = memberDAO.getAll();

        // Then
        Assertions.assertNotNull(members);
        Assertions.assertEquals(30, members.size());


    }


    @Test
    @Transactional
    public void testFacilityCount() throws SQLException {
        // When
        List<Facility> facilities = facilityDAO.getAll();

        // Then
        Assertions.assertNotNull(facilities);
        Assertions.assertEquals(9, facilities.size());
    }


}
