package com.eccom.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EccomSpringbootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EccomSpringbootStarterApplication.class, args);
	}

}
