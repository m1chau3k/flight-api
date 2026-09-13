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
public class AirportDTO {
    private Long id;
    private String icaoCode;
    private String iataCode;
    private String name;
    private String city;
    private String countryCode;
    private Double latitude;
    private Double longitude;
    private String timeZone;
}
