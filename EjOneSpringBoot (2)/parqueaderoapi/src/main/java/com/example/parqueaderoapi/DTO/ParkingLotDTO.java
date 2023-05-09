package com.example.parqueaderoapi.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter

public class ParkingLotDTO {
    private Long id;
    private String name;
    private String address;
    private Integer capacity;
    private BigDecimal pricePerHour;

}