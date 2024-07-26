package com.java.metaclassroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MetaclassroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetaclassroomApplication.class, args);
	}

}
