import app.SpringApplicationContext;
import app.SpringBootMicroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;


public class TestRST1 {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroService.class, args);

    }

}
