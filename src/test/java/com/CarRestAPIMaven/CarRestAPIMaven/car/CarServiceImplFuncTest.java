package com.CarRestAPIMaven.CarRestAPIMaven.car;

import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;
import com.CarRestAPIMaven.CarRestAPIMaven.exception.RecordNotFoundException;
import com.CarRestAPIMaven.CarRestAPIMaven.repository.CarRepository;
import com.CarRestAPIMaven.CarRestAPIMaven.service.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CarServiceImplFuncTest {

    @Autowired
    private CarServiceImpl carService;
    @Autowired
    private CarRepository carRepository;

    @Test
    public void verifySave() {
        Car car = Car.builder()
                .id(1L)
                .brand("BMW")
                .model("330d E46")
                .build();
        Car savedCar = carService.save(car);

        assertThat(car.getBrand(), is(savedCar.getBrand()));
        assertThat(savedCar.getId(), is(1L));
    }

    @Test
    public void verifyFindAll() {
        carService.findAll();
    }

    @Test
    public void verifyUpdate() {
        Car car = Car.builder()
                .id(1L)
                .brand("BMW")
                .model("330d E46")
                .build();
        Car updatedCar = carService.update(car, car.getId());

        assertThat(car.getId(), is(updatedCar.getId()));
    }

    @Test
    public void verifyFindById() {
        Car car = Car.builder()
                .id(1L)
                .brand("BMW")
                .model("330d E46")
                .build();
        Car savedCar = carService.save(car);
        Car foundCar = carService.findById(savedCar.getId());

        assertThat(foundCar.getId(), is(notNullValue()));
    }

    @Test
    public void verifyFindByIdThrowsException() {
        String message = "Кола с ID: 11 не е намерена!";

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            carService.findById(11L);
        });

        assertThat(message, is(exception.getMessage()));
    }
}


