package pl.aviation.flight_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class AircraftTypeDTO {
    private Long id;
    private String typeCode;
    private String manufacturer;
    private String model;
    private Integer passengerCapacity;
    private Integer range;
}
