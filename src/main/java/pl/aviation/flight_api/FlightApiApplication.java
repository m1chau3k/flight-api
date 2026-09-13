package pl.aviation.flight_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlightApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightApiApplication.class, args);
	}

}
