package com.mustaphaslimani.radarservice.web;

import com.mustaphaslimani.radarservice.entities.Radar;
import com.mustaphaslimani.radarservice.repositories.RadarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web")
public class RadarRestController {
    private final RadarRepository radarRepository;

    public RadarRestController(RadarRepository radarRepository) {
        this.radarRepository = radarRepository;
    }

    // Simple CRUD operations
    // - Read all
    @GetMapping("/radars")
    public List<Radar> getRadars(){
        return radarRepository.findAll();
    }

    // - Read by id
    @GetMapping("/radars/{id}")
    public Radar getRadar(@PathVariable("id") Long id){
        return radarRepository.findById(id).get();
    }

    // - Save
    @PostMapping("/radars")
    public Radar saveRadar(@RequestBody Radar radar){
        return radarRepository.save(radar);
    }

    // - Update
    @PutMapping("/radars/{id}")
    public Radar updateRadar(@PathVariable("id") Long id,@RequestBody Radar radar){
        if(radarRepository.existsById(id)){
            Radar savedRadar = radarRepository.findById(id).get();

            if(radar.getMaxSpeed() != null) savedRadar.setMaxSpeed(radar.getMaxSpeed());
            if(radar.getLatitude() != null) savedRadar.setLatitude(radar.getLatitude());
            if(radar.getLongitude() != null) savedRadar.setLongitude(radar.getLongitude());

            return radarRepository.save(savedRadar);
        }
        return null;
    }

    // - Delete
    @DeleteMapping("/radars/{id}")
    public boolean deleteRadar(@PathVariable("id") Long id){
        if(radarRepository.existsById(id)){
            radarRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
