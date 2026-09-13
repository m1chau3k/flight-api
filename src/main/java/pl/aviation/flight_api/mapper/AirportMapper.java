package pl.aviation.flight_api.mapper;

import lombok.experimental.UtilityClass;
import pl.aviation.flight_api.model.Airport;
import pl.aviation.flight_api.model.command.CreateAirportCommand;
import pl.aviation.flight_api.model.dto.AirportDTO;

@UtilityClass
public class AirportMapper {
    public AirportDTO mapToDTO(Airport airport) {
        return new AirportDTO()
                .setId(airport.getId())
                .setIcaoCode(airport.getIcaoCode())
                .setIataCode(airport.getIataCode())
                .setName(airport.getName())
                .setCity(airport.getCity())
                .setCountryCode(airport.getCountryCode())
                .setLatitude(airport.getLatitude())
                .setLongitude(airport.getLongitude())
                .setTimeZone(airport.getTimeZone());
    }

    public Airport mapToEntity(CreateAirportCommand createAirportCommand) {
        return Airport.builder()
                .icaoCode(createAirportCommand.getIcaoCode())
                .iataCode(createAirportCommand.getIataCode())
                .name(createAirportCommand.getName())
                .city(createAirportCommand.getCity())
                .countryCode(createAirportCommand.getCountryCode())
                .latitude(createAirportCommand.getLatitude())
                .longitude(createAirportCommand.getLongitude())
                .timeZone(createAirportCommand.getTimeZone())
                .build();
    }
}
