package springbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class SpringBookApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBookController.class, args);
    }
}
