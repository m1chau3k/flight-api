package pl.aviation.flight_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.aviation.flight_api.model.command.CreateAirportCommand;
import pl.aviation.flight_api.model.dto.AirportDTO;
import pl.aviation.flight_api.service.AirportService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public List<AirportDTO> getAll() {
        return airportService.getAll();
    }

    @GetMapping("/{id}")
    public AirportDTO getById(@PathVariable long id) {
        return airportService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AirportDTO create(@RequestBody @Valid CreateAirportCommand command) {
        return airportService.createAirport(command);
    }
}
