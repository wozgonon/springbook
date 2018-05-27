package springbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook.service.BookingService;

@Configuration
public class BookingConfiguration {

    @Bean
    public BookingService bookingService () {
        return new BookingService();
    }

}


