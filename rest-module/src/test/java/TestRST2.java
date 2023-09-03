import app.SpringApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRST2 {

    private static int port;

    private static ConfigurableApplicationContext context;


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
    public void testGetEndpoint() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:" + port + "/member";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("hello from get!", response.getBody());

    }

    @Test
    public void testPostEndpoint() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:" + port + "/member";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        assertEquals("hello from post", response.getBody());
    }
}
