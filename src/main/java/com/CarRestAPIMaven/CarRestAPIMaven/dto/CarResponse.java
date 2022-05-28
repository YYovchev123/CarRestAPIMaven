package com.CarRestAPIMaven.CarRestAPIMaven.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {

    private String brand;

    private String model;

    private Integer year;

    private String fuel;

    private Integer horsepower;

    private Double price;
}
