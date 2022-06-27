package de.rondevron.humidity.controllers;

import de.rondevron.humidity.models.HumidityDTO;
import de.rondevron.humidity.models.HumidityInfoDTO;
import de.rondevron.humidity.services.HumidityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/humidity")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HumidityController {

    private final HumidityService humidityService;

    @PostMapping
    public ResponseEntity<HumidityInfoDTO> calculateHumidityAbsolute(@RequestBody HumidityDTO humidity) {
        return ResponseEntity.ok().body(humidityService.calculateHumidityAbsolute(humidity));
    }
}
