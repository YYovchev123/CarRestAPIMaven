package com.CarRestAPIMaven.CarRestAPIMaven.service;

import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;

public interface CarService {

    Car save(Car car);
    Car findById(Long id);
    Car update(Car updatedCar, Long id);
    void deleteById(Long id);
    void deleteByBrand(String brand);
    void deleteByModel(String model);
}
