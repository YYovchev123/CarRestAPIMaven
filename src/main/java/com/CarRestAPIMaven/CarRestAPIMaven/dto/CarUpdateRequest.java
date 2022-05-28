package com.CarRestAPIMaven.CarRestAPIMaven.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class CarUpdateRequest {

    @NotNull
    private Long id;

    private String brand;

    private String model;

    private Integer year;

    private String fuel;

    private Integer horsepower;

    private Double price;
}
