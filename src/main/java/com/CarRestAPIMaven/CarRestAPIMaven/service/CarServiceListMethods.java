package com.CarRestAPIMaven.CarRestAPIMaven.service;

import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;

import java.util.List;

public interface CarServiceListMethods {

    List<Car> findAll();
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByFuel(String fuel);
}
