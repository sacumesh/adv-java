package data.services;

import app.messages.FacilityDTO;
import datamodel.Facility;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import services.FacilityDAO;

import java.util.ArrayList;
import java.util.List;

public class FacilityDataService {


    private final FacilityDAO facilityDAO;

    private final SessionFactory sf;

    public FacilityDataService(FacilityDAO facilityDAO, SessionFactory sf) {
        this.facilityDAO = facilityDAO;
        this.sf = sf;
    }

    public List<FacilityDTO> getAll() {
    List<FacilityDTO> res = new ArrayList<>();

        List<Facility> facilities = facilityDAO.getAll();
        for(Facility facility: facilities){
            FacilityDTO facilityDTO = new FacilityDTO(facility);
            res.add(facilityDTO);
        }

        return res;
    }


    @Transactional
    public FacilityDTO createFacility(FacilityDTO facilityDTO) {
        Facility facility = new Facility();
        facility.setName(facilityDTO.getName());
        facility.setMemberCost(facilityDTO.getMemberCost());
        facility.setGuestCost(facilityDTO.getGuestCost()); // Assuming guestCost is not set in FacilityDTO
        facility.setInitialOutlay(facilityDTO.getInitialOutlay());
        facility.setMonthlyMaintenance(facilityDTO.getMonthlyMaintenance());

        facilityDAO.create(facility);

        FacilityDTO createdFacilityDTO = new FacilityDTO(facility);
        return createdFacilityDTO;
    }


}
