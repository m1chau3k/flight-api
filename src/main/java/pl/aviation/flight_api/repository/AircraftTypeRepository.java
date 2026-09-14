package pl.aviation.flight_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aviation.flight_api.model.AircraftType;

public interface AircraftTypeRepository extends JpaRepository<AircraftType, Long> {
    boolean existsByTypeCode(String typeCode);
}
