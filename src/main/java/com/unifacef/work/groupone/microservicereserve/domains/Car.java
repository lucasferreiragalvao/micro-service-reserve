package com.unifacef.work.groupone.microservicereserve.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String code;
    private int year;
    private Classification classification;
    private String color;
    private Brand brand;
    private String model;
    private String name;
    private String board;
    private Double tankSize;
    private Long odomenter;
    private Boolean isActive;
    private String note;
}
