package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

@SpringBootApplication
public class SpringBootMicroService {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroService.class, args);
    }


}
