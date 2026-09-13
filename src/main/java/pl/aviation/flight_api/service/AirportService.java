package pl.aviation.flight_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.aviation.flight_api.mapper.AirportMapper;
import pl.aviation.flight_api.model.Airport;
import pl.aviation.flight_api.model.command.CreateAirportCommand;
import pl.aviation.flight_api.model.dto.AirportDTO;
import pl.aviation.flight_api.repository.AirportRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;

    @Transactional
    public AirportDTO createAirport(CreateAirportCommand  command) {
        if (airportRepository.existsByIcaoCode(command.getIcaoCode())) {
            throw new IllegalArgumentException(
                    MessageFormat.format("Airport with ICAO code {0} already exists", command.getIcaoCode())
            );
        }

        if (airportRepository.existsByIataCode(command.getIataCode())) {
            throw new IllegalArgumentException(
                    MessageFormat.format("Airport with IATA code {0} already exists", command.getIataCode())
            );
        }
        Airport airport = AirportMapper.mapToEntity(command);
        return AirportMapper.mapToDTO(airportRepository.save(airport));
    }

    public List<AirportDTO> getAll() {
        return airportRepository.findAll().stream()
                .map(AirportMapper::mapToDTO)
                .toList();
    }

    public AirportDTO getById(long id) {
        return airportRepository.findById(id)
                .map(AirportMapper::mapToDTO)
                .orElseThrow(() -> new NoSuchElementException(
                        MessageFormat.format(
                            "Airport with id {0} not found.", id)
                ));
    }
}
