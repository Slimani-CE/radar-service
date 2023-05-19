package com.mustaphaslimani.radarservice;

import com.mustaphaslimani.radarservice.entities.Radar;
import com.mustaphaslimani.radarservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RadarServiceApplication implements CommandLineRunner {

	private final RadarRepository radarRepository;

	public RadarServiceApplication(RadarRepository radarRepository) {
		this.radarRepository = radarRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RadarServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add some radars
		for(int i = 0; i < 10; i++) {
			Radar radar = new Radar();
			radar.setMaxSpeed(100.0 + i);
			radar.setLatitude(36.0 + i);
			radar.setLongitude(10.0 + i);
			radarRepository.save(radar);
			System.out.println(radar);
		}
	}
}
