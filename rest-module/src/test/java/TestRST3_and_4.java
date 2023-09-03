import app.SpringApplicationContext;
import app.messages.FacilityDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import datamodel.Booking;
import datamodel.Facility;
import datamodel.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.*;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.client.RestTemplate;
import services.FacilityDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringApplicationContext.class)
public class TestRST3_and_4 {
    private static int port;

    private static ConfigurableApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FacilityDAO facilityDAO;

    @Autowired
    private SessionFactory sf;


    @BeforeAll
    public static void setup() {
        port = 8080;
        context = SpringApplication.run(app.SpringBootMicroService.class, "--server.port=" + port);
    }

    @AfterAll
    public static void clean() {
        context.close();
    }

    @Test
    public void testGetEndpoint() throws JsonProcessingException {

        // Given
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:" + port + "/facilities";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        Facility facility = new Facility("Abc Facility", 200, 200, 200, 200);
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        // sync the transactions for manually opened sessions
        TransactionSynchronizationManager.bindResource(sf, new SessionHolder(session));
        facilityDAO.create(facility);
        transaction.commit();
        TransactionSynchronizationManager.unbindResource(sf);


        // when
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Then
        FacilityDTO[] facilityDTOs = objectMapper.readValue(response.getBody(), FacilityDTO[].class);
        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue (facilityDTOs.length > 0);
    }

    @Test
    public void testPostEndpoint() throws JsonProcessingException {
        // Given
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:" + port + "/facilities";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        FacilityDTO facilityDTO = new FacilityDTO("Sample Facility", 100, 150, 500, 50);
        String requestBody = objectMapper.writeValueAsString(facilityDTO);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // When
        ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.POST, entity, FacilityDTO.class);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
