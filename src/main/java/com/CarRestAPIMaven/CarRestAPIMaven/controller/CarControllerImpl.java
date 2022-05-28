package com.CarRestAPIMaven.CarRestAPIMaven.controller;

import com.CarRestAPIMaven.CarRestAPIMaven.converter.CarConverter;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarResponse;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarSaveRequest;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarUpdateRequest;
import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;
import com.CarRestAPIMaven.CarRestAPIMaven.service.CarService;
import com.CarRestAPIMaven.CarRestAPIMaven.service.CarServiceListMethods;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/cars")
public class CarControllerImpl implements CarController, CarControllerListResponse{

    private final CarConverter carConverter;
    private final CarService carService;
    private final CarServiceListMethods carServiceList;

    @Override
    @PostMapping
    public ResponseEntity<CarResponse> save(@RequestBody @Valid CarSaveRequest carSaveRequest) {
        Car car = carConverter.convert(carSaveRequest);
        Car savedCar = carService.save(car);
        CarResponse carResponse = carConverter.convert(savedCar);
        return ResponseEntity.ok().body(carResponse);

    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<CarResponse> update(@RequestBody @Valid CarUpdateRequest carUpdateRequest) {
        Car car = carConverter.convert(carUpdateRequest);
        Car updatedCar = carService.update(car, car.getId());
        CarResponse carResponse = carConverter.convert(updatedCar);
        return ResponseEntity.ok().body(carResponse);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<CarResponse> findById(@PathVariable Long id) {
        Car car = carService.findById(id);
        CarResponse carResponse = carConverter.convert(car);
        return ResponseEntity.ok().body(carResponse);
    }

    @Override
    @DeleteMapping(value = "/id/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/brand/delete/{brand}")
    public ResponseEntity<HttpStatus> deleteByBrand(@PathVariable String brand) {
        carService.deleteByBrand(brand);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/model/delete/{model}")
    public ResponseEntity<HttpStatus> deleteByModel(@PathVariable String model) {
        carService.deleteByModel(model);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping(value = "/brand/{brand}")
    public ResponseEntity<List<CarResponse>> findByBrand(@PathVariable String brand) {
        List<CarResponse> carResponses = carServiceList.findByBrand(brand).stream().map(carConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok().body(carResponses);
    }

    @Override
    @GetMapping(value = "/model/{model}")
    public ResponseEntity<List<CarResponse>> findByModel(@PathVariable String model) {
        List<CarResponse> carResponses = carServiceList.findByModel(model).stream().map(carConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok().body(carResponses);
    }

    @Override
    @GetMapping(value = "/fuel/{fuel}")
    public ResponseEntity<List<CarResponse>> findByFuel(@PathVariable String fuel) {
        List<CarResponse> carResponses = carServiceList.findByFuel(fuel).stream().map(carConverter::convert).collect(Collectors.toList());
        return ResponseEntity.ok().body(carResponses);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CarResponse>> findAll() {
        return ResponseEntity.ok(carServiceList.findAll().stream().map(carConverter::convert).collect(Collectors.toList()));
    }
}
