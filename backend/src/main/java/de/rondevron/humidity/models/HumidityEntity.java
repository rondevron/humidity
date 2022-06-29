package de.rondevron.humidity.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "humidity")
@NoArgsConstructor
@Table()
public class HumidityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "humidity_id", updatable = false)
    private Long id;

    @Column(name = "temperature", columnDefinition = "TEXT")
    private double temperature;

    @Column(name = "humidity", columnDefinition = "TEXT")
    private double humidity;

    @ManyToOne
    @JoinColumn(name = "humidity_id", nullable = false, insertable = false, updatable = false)
    private HumidityEntity user;

    public HumidityEntity(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
