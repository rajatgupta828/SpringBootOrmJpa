package com.rajat.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.rajat.learning.controllers", "com.rajat.learning.repos"})
public class SpringBootOrmJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrmJpaApplication.class, args);
	}

}
