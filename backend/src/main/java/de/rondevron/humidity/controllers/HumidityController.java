package de.rondevron.humidity.controllers;

import de.rondevron.humidity.models.HumidityInfoDTO;
import de.rondevron.humidity.services.HumidityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/humidity")
public class HumidityController {

    private final HumidityService humidityService;

    @GetMapping
    public ResponseEntity<HumidityInfoDTO> calculateHumidityAbsolute(
            @RequestParam("temperature") double temperature,
            @RequestParam("humidity") double humidity)
    {
        return ResponseEntity.ok().body(humidityService.calculateHumidityAbsolute(temperature, humidity));
    }
}
