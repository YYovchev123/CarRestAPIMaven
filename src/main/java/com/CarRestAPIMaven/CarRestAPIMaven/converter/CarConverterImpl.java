package com.CarRestAPIMaven.CarRestAPIMaven.converter;

import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarResponse;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarSaveRequest;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarUpdateRequest;
import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Primary
public class CarConverterImpl implements CarConverter{

    @Override
    public Car convert(CarSaveRequest carSaveRequest) {
        return Car.builder()
                .brand(carSaveRequest.getBrand())
                .model(carSaveRequest.getModel())
                .year(carSaveRequest.getYear())
                .fuel(carSaveRequest.getFuel())
                .horsepower(carSaveRequest.getHorsepower())
                .price(carSaveRequest.getPrice())
                .build();
    }

    @Override
    public CarResponse convert(Car car) {
        return CarResponse.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .fuel(car.getFuel())
                .horsepower(car.getHorsepower())
                .price(car.getPrice())
                .build();
    }

    @Override
    public Car convert(CarUpdateRequest carUpdateRequest) {
        return Car.builder()
                .id(carUpdateRequest.getId())
                .brand(carUpdateRequest.getBrand())
                .model(carUpdateRequest.getModel())
                .year(carUpdateRequest.getYear())
                .fuel(carUpdateRequest.getFuel())
                .horsepower(carUpdateRequest.getHorsepower())
                .price(carUpdateRequest.getPrice())
                .build();
    }
}
