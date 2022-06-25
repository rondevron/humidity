package de.rondevron.humidity.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class HumidityInfoDTO implements Serializable {

    private double temperature;

    private double humidity;

    private double humidityAbsolute;

    private double humidityAbsolute2;

    private double dewPount;
}
