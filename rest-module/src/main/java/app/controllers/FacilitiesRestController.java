package app.controllers;

import app.messages.FacilityDTO;
import data.services.FacilityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("facilities")
public class FacilitiesRestController {

    @Autowired
    FacilityDataService facilityDataService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        try {
            List<FacilityDTO> facilityDTOList = facilityDataService.getAll();
            return ResponseEntity.ok().body(facilityDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving facilities");
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFacility(@RequestBody FacilityDTO facilityDTO) {
        try {
            FacilityDTO createdFacility = facilityDataService.createFacility(facilityDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFacility);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating facility");
        }
    }
}
