package pl.aviation.flight_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aviation.flight_api.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    boolean existsByIcaoCode(String icaoCode);
    boolean existsByIataCode(String iataCode);
}
