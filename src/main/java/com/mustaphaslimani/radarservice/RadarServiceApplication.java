package com.mustaphaslimani.radarservice;

import com.mustaphaslimani.radarservice.entities.Radar;
import com.mustaphaslimani.radarservice.feign.InfractionFeignClient;
import com.mustaphaslimani.radarservice.feign.RegistrationFeignClient;
import com.mustaphaslimani.radarservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RadarServiceApplication implements CommandLineRunner {

	private final RadarRepository radarRepository;
	private final RegistrationFeignClient registrationFeignClient;
	private final InfractionFeignClient infractionFeignClient;

	public RadarServiceApplication(RadarRepository radarRepository, RegistrationFeignClient registrationFeignClient, InfractionFeignClient infractionFeignClient) {
		this.radarRepository = radarRepository;
		this.registrationFeignClient = registrationFeignClient;
		this.infractionFeignClient = infractionFeignClient;
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
		// Add new infraction by radar 3 and vehicle 2

	}
}
