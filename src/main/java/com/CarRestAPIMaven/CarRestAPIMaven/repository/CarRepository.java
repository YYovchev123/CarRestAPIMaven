package com.CarRestAPIMaven.CarRestAPIMaven.repository;

import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<List<Car>> findByBrand(String brand);
    Optional<List<Car>> findByModel(String model);
    Optional<List<Car>> findByFuel(String fuel);

    void deleteByBrand(String brand);
    void deleteByModel(String model);

    boolean existsByBrand(String brand);
    boolean existsByModel(String model);
}
