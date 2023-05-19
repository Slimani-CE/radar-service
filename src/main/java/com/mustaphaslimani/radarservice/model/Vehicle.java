package com.mustaphaslimani.radarservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class Vehicle {
    private Long id;
    private String regNumber;
    private String brand;
    private Float fiscalPower;
    private String model;
    private Owner owner;
}
