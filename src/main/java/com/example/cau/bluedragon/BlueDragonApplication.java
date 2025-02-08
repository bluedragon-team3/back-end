package com.example.cau.bluedragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlueDragonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueDragonApplication.class, args);
	}

}
