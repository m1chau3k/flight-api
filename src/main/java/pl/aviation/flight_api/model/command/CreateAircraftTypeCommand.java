package pl.aviation.flight_api.model.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateAircraftTypeCommand {
    @NotBlank(message = "ICAO/IATA code cannot be blank")
    @Size(min = 3, max = 4, message = "Code should read 3 or 4 characters")
    private String typeCode;
    @NotBlank(message = "Manufacturer code cannot be blank")
    private String manufacturer;
    @NotBlank(message = "Model code cannot be blank")
    private String model;
    @PositiveOrZero(message = "Passenger capacity have to be provided, even for cargo planes (0)")
    private Integer passengerCapacity;
    @PositiveOrZero(message = "Range have to be provided")
    private Integer range;
}
