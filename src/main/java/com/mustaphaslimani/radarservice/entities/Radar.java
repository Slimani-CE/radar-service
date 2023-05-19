package com.mustaphaslimani.radarservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity @ToString
@AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double maxSpeed;
    private Double longitude;
    private Double latitude;
}
