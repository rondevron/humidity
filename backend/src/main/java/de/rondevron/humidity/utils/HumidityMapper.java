package de.rondevron.humidity.utils;

import de.rondevron.humidity.models.HumidityDTO;
import de.rondevron.humidity.models.HumidityEntity;

public class HumidityMapper {
    public HumidityMapper() {
    }

    public static HumidityDTO map(HumidityEntity obj) {
        return new HumidityDTO(
                obj.getTemperature(),
                obj.getHumidity()
        );
    }
}
