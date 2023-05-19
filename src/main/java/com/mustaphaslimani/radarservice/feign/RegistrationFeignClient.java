package com.mustaphaslimani.radarservice.feign;

import com.mustaphaslimani.radarservice.model.Owner;
import com.mustaphaslimani.radarservice.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "REGISTRATION-SERVICE")
public interface RegistrationFeignClient {
    // Check if owner exists
    @GetMapping("/web/owners/exist/{id}")
    boolean isOwnerExistsById(@PathVariable("id") Long id);

    // Get owner
    @GetMapping("/web/owners/{id}")
    Owner getOwner(@PathVariable("id") Long id);

    // Check if vehicle exists
    @GetMapping("/web/vehicles/exist/{id}")
    boolean isVehicleExistsById(@PathVariable("id") Long id);

    // Get vehicle
    @GetMapping("/web/vehicles/{id}")
    Vehicle getVehicle(@PathVariable("id") Long id);
}
