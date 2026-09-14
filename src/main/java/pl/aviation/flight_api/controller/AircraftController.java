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
import pl.aviation.flight_api.model.command.CreateAircraftTypeCommand;
import pl.aviation.flight_api.model.dto.AircraftTypeDTO;
import pl.aviation.flight_api.service.AircraftTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aircraft-types")
@RequiredArgsConstructor
public class AircraftController {
    private final AircraftTypeService aircraftTypeService;

    @GetMapping
    public List<AircraftTypeDTO> getAll() {
        return aircraftTypeService.getAll();
    }

    @GetMapping("/{id}")
    public AircraftTypeDTO getById(@PathVariable long id) {
        return aircraftTypeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AircraftTypeDTO create(@RequestBody @Valid CreateAircraftTypeCommand command) {
        return aircraftTypeService.createAircraftType(command);
    }
}
