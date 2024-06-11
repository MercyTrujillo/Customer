package com.amdocs.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication

public class CustomerApplication {
	private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CustomerApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
		log.info("Mercy Jacqueline Trujillo Rodriguezzzzzz");
	}

}
