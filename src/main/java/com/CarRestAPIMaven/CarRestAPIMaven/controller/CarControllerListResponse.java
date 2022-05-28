package com.CarRestAPIMaven.CarRestAPIMaven.controller;

import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarControllerListResponse {

    ResponseEntity<List<CarResponse>> findByBrand(String brand);

    ResponseEntity<List<CarResponse>> findByModel(String model);

    ResponseEntity<List<CarResponse>> findByFuel(String fuel);

    ResponseEntity<List<CarResponse>> findAll();
}
