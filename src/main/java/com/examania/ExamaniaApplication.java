package com.examania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExamaniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamaniaApplication.class, args);
	}

}
