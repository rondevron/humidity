package de.rondevron.humidity.services;

import de.rondevron.humidity.models.HumidityInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HumidityService {

//    public HumidityInfoDTO calculateHumidityAbsolute2(final double temperature, double relativeHumidity) {
//        if (relativeHumidity > 1) {
//            relativeHumidity = 1;
//        }
//        // Pw = e / (Rw * T) -> absolute humidity = steam (water vapour) / (gas constant * absolute Temperature)
//        // x = RG / RD = (φ x ps) / p - φ x ps
//        //double ps = 1936.3; // N/m2, saturation pressure of water vapour
//        double ps = 0.02986;
//        double rd = 461.52; // J/(kg K), Nm/kg K, gas constant of water vapour
//        double p = 0.9552; // bar
//        //double waterVapour = relativeHumidity * ps;
//
//        double absHumidity = (relativeHumidity * ps) / (p - relativeHumidity * ps);
//        return new HumidityInfoDTO(temperature, relativeHumidity, absHumidity);
//    }

    public HumidityInfoDTO calculateHumidityAbsolute(final double temperature, double relativeHumidity) {
        double a;
        double b;

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
}
