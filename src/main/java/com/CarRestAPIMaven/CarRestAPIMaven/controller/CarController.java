package com.CarRestAPIMaven.CarRestAPIMaven.controller;

import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarResponse;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarSaveRequest;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarController {

    ResponseEntity<CarResponse> save(CarSaveRequest carSaveRequest);

    ResponseEntity<CarResponse> update(CarUpdateRequest carUpdateRequest);

    ResponseEntity<CarResponse> findById(Long id);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<HttpStatus> deleteByBrand(String brand);

    ResponseEntity<HttpStatus>  deleteByModel(String model);

}
