package com.example.xquareassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class XquareAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(XquareAssignmentApplication.class, args);
	}

}
