package de.rondevron.humidity.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HumidityDTO {
    private double temperature;
    private double humidity;
}
