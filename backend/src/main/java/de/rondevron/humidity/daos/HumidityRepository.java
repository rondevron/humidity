package de.rondevron.humidity.daos;

import de.rondevron.humidity.models.HumidityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumidityRepository extends JpaRepository<HumidityEntity, Long> {
}
