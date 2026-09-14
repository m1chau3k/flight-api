package pl.aviation.flight_api.mapper;

import lombok.experimental.UtilityClass;
import pl.aviation.flight_api.model.AircraftType;
import pl.aviation.flight_api.model.command.CreateAircraftTypeCommand;
import pl.aviation.flight_api.model.dto.AircraftTypeDTO;

@UtilityClass
public class AircraftTypeMapper {
    public AircraftTypeDTO mapToDTO(AircraftType aircraftType) {
        return new AircraftTypeDTO()
                .setId(aircraftType.getId())
                .setTypeCode(aircraftType.getTypeCode())
                .setManufacturer(aircraftType.getManufacturer())
                .setModel(aircraftType.getModel())
                .setPassengerCapacity(aircraftType.getPassengerCapacity())
                .setRange(aircraftType.getRange());
    }
    public AircraftType mapToEntity(CreateAircraftTypeCommand createAircraftTypeCommand) {
        return AircraftType.builder()
                .typeCode(createAircraftTypeCommand.getTypeCode())
                .manufacturer(createAircraftTypeCommand.getManufacturer())
                .model(createAircraftTypeCommand.getModel())
                .passengerCapacity(createAircraftTypeCommand.getPassengerCapacity())
                .range(createAircraftTypeCommand.getRange())
                .build();
    }
}
