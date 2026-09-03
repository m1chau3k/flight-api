package pl.aviation.flight_api;

import org.springframework.boot.SpringApplication;

public class TestFlightApiApplication {

	static void main(String[] args) {
		SpringApplication.from(FlightApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
