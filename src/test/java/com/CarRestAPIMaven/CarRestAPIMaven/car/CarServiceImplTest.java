package com.CarRestAPIMaven.CarRestAPIMaven.car;

import com.CarRestAPIMaven.CarRestAPIMaven.entity.Car;
import com.CarRestAPIMaven.CarRestAPIMaven.exception.RecordNotFoundException;
import com.CarRestAPIMaven.CarRestAPIMaven.repository.CarRepository;
import com.CarRestAPIMaven.CarRestAPIMaven.service.CarServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;
    private CarServiceImpl carService;

    @BeforeEach
    public void setUp() {
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    public void verifyFindAll() {
        when(carRepository.findAll()).thenReturn(List.of(Car.builder().build()));
        carService.findAll();
        verify(carRepository, times(1)).findAll();
    }

    @Test
    public void verifySave() {
        Car car = Car.builder().build();
        carService.save(car);
        verify(carRepository, times(1)).save(car);
    }

    public void verifyUpdate() {
        Car car = Car.builder()
                .id(1L)
                .brand("BMW")
                .model("330cd E46")
                .price(7999.99)
                .horsepower(204)
                .fuel("diesel")
                .year(2004)
                .build();
        when(carRepository.findById(car.getId())).thenReturn(Optional.of(Car.builder()
                .id(1L)
                .brand("BMW")
                .model("330cd E46")
                .price(7999.99)
                .horsepower(204)
                .fuel("diesel")
                .year(2004)
                .build()));

        Car returnedCar = carService.update(car , car.getId());
        assertEquals(car.getId() , returnedCar.getId());
    }

    @Test
    public void verifyFindById() {
        Long id = 1L;
        when(carRepository.findById(id)).thenReturn(Optional.of(Car.builder().build()));
        carService.findById(id);
        verify(carRepository, times(1)).findById(id);
    }

    @Test
    public void verifyDeleteById() {
        Long id = 1L;
        carService.deleteById(id);
        verify(carRepository, times(1)).deleteById(id);
    }

    @Test
    public void verifyDeleteByBrand() {
        String brand = "BMW";
        carService.deleteByBrand(brand);
        verify(carRepository, times(1)).deleteByBrand(brand);
    }

    @Test
    public void verifyDeleteByModel(){
        String model = "328i E46";
        carService.deleteByModel(model);
        verify(carRepository, times(1)).deleteByModel(model);
    }

    @Test
    public void verifyFindByBrand() {
        String brand = "BMW";
        when(carRepository.findByBrand(brand)).thenReturn(Optional.of(List.of(Car.builder()
                .brand(brand)
                .build())));
        carService.findByBrand(brand);
        verify(carRepository, times(1)).findByBrand(brand);
    }

    @Test
    public void verifyFindByModel() {
        String model = "328i E36";
        when(carRepository.findByModel(model)).thenReturn(Optional.of(List.of(Car.builder()
                .model(model)
                .build())));
        carService.findByModel(model);
        verify(carRepository, times(1)).findByModel(model);
    }

    @Test
    public void verifyFindByFuel() {
        String fuel = "petrol";
        when(carRepository.findByFuel(fuel)).thenReturn(Optional.of(List.of(Car.builder()
                .fuel(fuel)
                .build())));
        carService.findByFuel(fuel);
        verify(carRepository, times(1)).findByFuel(fuel);
    }

    @Test
    public void verifyFindByModelThrowsException() {
        String message = "Коли с модел M3 не са намерени!";
        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            carService.findByModel("M3");
        });
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void verifyFindByBrandThrowsException() {
        String message = "Коли с марка BMW не са намерени!";
        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            carService.findByBrand("BMW");
        });
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void verifyFindByFuelThrowsException() {
        String message = "Коли с гориво diesel не са намерени!";
        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            carService.findByFuel("diesel");
        });
        assertEquals(message, exception.getMessage());
    }
}
