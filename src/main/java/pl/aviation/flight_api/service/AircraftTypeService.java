package pl.aviation.flight_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.aviation.flight_api.mapper.AircraftTypeMapper;
import pl.aviation.flight_api.model.AircraftType;
import pl.aviation.flight_api.model.command.CreateAircraftTypeCommand;
import pl.aviation.flight_api.model.dto.AircraftTypeDTO;
import pl.aviation.flight_api.repository.AircraftTypeRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AircraftTypeService {
    private final AircraftTypeRepository aircraftTypeRepository;

    @Transactional
    public AircraftTypeDTO createAircraftType(CreateAircraftTypeCommand command) {
        if (aircraftTypeRepository.existsByTypeCode(command.getTypeCode())) {
            throw new IllegalArgumentException(
                    MessageFormat.format("Aircraft type with code {0} already exists", command.getTypeCode())
            );
        }

        AircraftType aircraftType = AircraftTypeMapper.mapToEntity(command);
        return AircraftTypeMapper.mapToDTO(aircraftTypeRepository.save(aircraftType));
    }

    public List<AircraftTypeDTO> getAll() {
        return aircraftTypeRepository.findAll().stream()
                .map(AircraftTypeMapper::mapToDTO)
                .toList();
    }

    public AircraftTypeDTO getById(long id) {
        return aircraftTypeRepository.findById(id)
                .map(AircraftTypeMapper::mapToDTO)
                .orElseThrow(() -> new NoSuchElementException(
                        MessageFormat.format("Aircraft with id {0} not found.", id)
                ));
    }
}
