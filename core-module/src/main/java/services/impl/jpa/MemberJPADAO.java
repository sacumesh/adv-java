package services.impl.jpa;

import datamodel.Member;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import services.MemberDAO;

import java.util.List;
@Repository
public class MemberJPADAO extends AbstractJPADAO<Member> implements MemberDAO {


    public MemberJPADAO(SessionFactory sf) {
        super(sf, Member.class);
    }


    @Override
    public List<Member> search(Member instance) {
        return null;
    }

}
