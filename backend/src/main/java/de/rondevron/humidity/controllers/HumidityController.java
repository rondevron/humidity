package de.rondevron.humidity.controllers;

import de.rondevron.humidity.models.HumidityDTO;
import de.rondevron.humidity.models.HumidityInfoDTO;
import de.rondevron.humidity.services.HumidityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/humidity")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HumidityController {

    private final HumidityService humidityService;

    @Operation(summary = "Calculate humidity related values.",
            description = "Calculate humidity related values with specified temperature and relativ humidity.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Calculation successfully.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HumidityInfoDTO.class))})
    })
    @PostMapping("/calc")
    public ResponseEntity<HumidityInfoDTO> calculateHumidityAbsolute(@RequestBody HumidityDTO humidity) {
        return ResponseEntity.ok().body(humidityService.calculateHumidityAbsolute(humidity));
    }

    @Operation(summary = "Save humidity data.",
            description = "Save humidity data to specified data base e.g. for historical analysis.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Data successfully stored.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HumidityDTO.class))})
    })
    @PutMapping("/sensor")
    public ResponseEntity<HumidityDTO> saveHumidityData(@RequestBody HumidityDTO humidity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(humidityService.saveHumidityData(humidity));
    }

    @Operation(summary = "Get all humidity data.",
            description = "Get all humidity data e.g. for historical analysis.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get all stored data.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(
                                    schema = @Schema(implementation = HumidityDTO.class)))})
    })
    @GetMapping("/sensor")
    public ResponseEntity<List<HumidityDTO>> getAllHumidityData() {
        return ResponseEntity.ok().body(humidityService.getHumidities());
    }
}
