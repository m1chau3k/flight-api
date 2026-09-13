package pl.aviation.flight_api.model.command;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateAirportCommand {
    @NotBlank(message = "ICAO code cannot be blank")
    @Size(min = 4, max = 4, message = "ICAO code must be exactly 4 characters")
    private String icaoCode;
    @NotEmpty
    @Size(min = 3, max = 3, message = "IATA code must be exactly 3 characters")
    private String iataCode;
    @NotBlank(message = "Airport name cannot be blank")
    private String name;
    @NotBlank(message = "City name cannot be blank")
    private String city;
    @NotBlank(message = "Country code cannot be blank")
    @Size(min = 2, max = 2, message = "Country code must be exactly 2 characters")
    private String countryCode;
    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private Double latitude;
    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private Double longitude;
    @NotBlank(message = "Timezone cannot be blank")
    private String timeZone;
}
