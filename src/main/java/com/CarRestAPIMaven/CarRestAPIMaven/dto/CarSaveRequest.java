package com.CarRestAPIMaven.CarRestAPIMaven.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class CarSaveRequest {

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private Integer year;

    @NotNull
    private String fuel;

    @NotNull
    private Integer horsepower;

    private Double price;
}
