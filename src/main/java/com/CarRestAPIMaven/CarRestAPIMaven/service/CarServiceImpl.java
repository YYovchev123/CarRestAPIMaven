package com.CarRestAPIMaven.CarRestAPIMaven.service;

import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;
import com.CarRestAPIMaven.CarRestAPIMaven.exception.RecordNotFoundException;
import com.CarRestAPIMaven.CarRestAPIMaven.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
@Transactional
public class CarServiceImpl implements CarService, CarServiceListMethods{

    private final CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Кола с ID: %s не е намерена!", id)));
    }

    @Override
    public Car update(Car updatedCar, Long id) {
        Car car = findById(id);
        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setPrice(updatedCar.getPrice());
        car.setFuel(updatedCar.getFuel());
        car.setHorsepower(updatedCar.getHorsepower());
        car.setYear(updatedCar.getYear());
        return car;
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void deleteByBrand(String brand) {
        carRepository.deleteByBrand(brand);
    }

    @Override
    public void deleteByModel(String model) {
        carRepository.deleteByModel(model);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand).orElseThrow(() -> new RecordNotFoundException(String.format("Коли с марка %s не са намерени!", brand)));
    }

    @Override
    public List<Car> findByModel(String model) {
        return carRepository.findByModel(model).orElseThrow(() -> new RecordNotFoundException(String.format("Коли с модел %s не са намерени!", model)));
    }

    @Override
    public List<Car> findByFuel(String fuel) {
        return carRepository.findByFuel(fuel).orElseThrow(() -> new RecordNotFoundException(String.format("Коли с гориво %s не са намерени!", fuel)));
    }
}
