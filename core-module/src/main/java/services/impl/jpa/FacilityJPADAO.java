package services.impl.jpa;

import datamodel.Facility;

import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import services.FacilityDAO;

import java.util.List;
public class FacilityJPADAO extends AbstractJPADAO<Facility> implements FacilityDAO {

    public FacilityJPADAO(SessionFactory sf) {
        super(sf, Facility.class);
    }


    @Override
    public List<Facility> search(Facility instance) {
        return null;
    }

}
