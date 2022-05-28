package com.CarRestAPIMaven.CarRestAPIMaven.converter;

import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarResponse;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarSaveRequest;
import com.CarRestAPIMaven.CarRestAPIMaven.dto.CarUpdateRequest;
import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;

public interface CarConverter {

    Car convert(CarSaveRequest carSaveRequest);

    CarResponse convert(Car car);

    Car convert(CarUpdateRequest carUpdateRequest);
}
