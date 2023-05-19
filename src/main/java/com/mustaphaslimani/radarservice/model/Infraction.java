package com.mustaphaslimani.radarservice.model;

import com.mustaphaslimani.radarservice.entities.Radar;
import lombok.*;

@Data  @ToString  @Builder
@AllArgsConstructor @NoArgsConstructor
public class Infraction {
    private Long id;
    private String date;
    private Double vehicleSpeed;
    private Double radarMaxSpeed;
    private Double fineAmount;
    private Long radarId;
    private Long vehicleId;
    private Vehicle vehicle;
    private Radar radar;
}
