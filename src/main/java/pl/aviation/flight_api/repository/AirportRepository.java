package pl.aviation.flight_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aviation.flight_api.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findById(long id);
}
