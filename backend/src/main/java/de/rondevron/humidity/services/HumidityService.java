package de.rondevron.humidity.services;

import de.rondevron.humidity.daos.HumidityRepository;
import de.rondevron.humidity.models.HumidityDTO;
import de.rondevron.humidity.models.HumidityEntity;
import de.rondevron.humidity.models.HumidityInfoDTO;
import de.rondevron.humidity.utils.HumidityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HumidityService {

    private final HumidityRepository humidityRepository;


    public HumidityInfoDTO calculateHumidityAbsolute(final HumidityDTO humidity) {
        double a;
        double b;
        double temperature = humidity.getTemperature();
        double relativeHumidity = humidity.getHumidity();

        if (temperature >= 0.0) { // T >= 0 °C
            a = 7.5;
            b = 237.3;
        } else { // T < 0 °C ueber Wasser
            a = 7.6;
            b = 240.7;
        }

        final double R = 8314.3; // J/(kmol*K) (universelle Gaskonstante)
        final double mw = 18.016; // kg/kmol (Molekulargewicht des Wasserdampfes)

        double SDD = (6.1078 * Math.pow(10.0, ((a * temperature) / (b + temperature))));
        double DD = (relativeHumidity / 100 * SDD);
        double v = Math.log10((DD / 6.1078));
        double TD = ((b * v) / (a - v)); //dew point in degrees
        double TK = temperature + 273.15; // temperature in kelvin
        double AF = Math.pow(10.0, 5) * mw / R * DD / TK;
        double AF2 = Math.pow(10.0, 5) * mw / R * SDD / TK;

        return new HumidityInfoDTO(temperature, relativeHumidity, AF, AF2, TD);
    }

    public List<HumidityDTO> getHumidities() {
        return humidityRepository.findAll()
                .stream()
                .map(HumidityMapper::map)
                .collect(Collectors.toList());
    }

    public HumidityDTO saveHumidityData(HumidityDTO humidityDTO) {
        final HumidityEntity obj = new HumidityEntity(
                humidityDTO.getTemperature(),
                humidityDTO.getHumidity()
        );
        humidityRepository.save(obj);

        return HumidityMapper.map(obj); // ToDo HumidityInfoDTO e.g. Date
    }
}
